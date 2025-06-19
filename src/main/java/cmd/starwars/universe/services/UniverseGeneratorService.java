package cmd.starwars.universe.services;

import cmd.starwars.universe.config.TopicsConfig;
import cmd.starwars.universe.model.enums.*;
import cmd.starwars.universe.repo.entities.*;
import cmd.starwars.universe.services.data.*;
import cmd.starwars.universe.services.impl.RandomElementImpl;
import cmd.starwars.universe.services.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniverseGeneratorService {
    private final AllegianceService alleginaces;
    private final StatusService statuses;
    private final ShipClassService shipClasses;
    private final UnitClassService unitClasses;
    private final HeroService heroes;
    private final PlanetService planets;
    private final ShipClassService shipClass;
    private final ShipService ships;
    private final StarSystemService starSystems;
    private final TrooperService troopers;
    private final RandomElement randomElement;
    private final KafkaSender kafkaSender;
    private final NameGenerator nameGenerator;
    private final TopicsConfig topics;

    @Autowired
    public UniverseGeneratorService(AllegianceService alleginaces,
                                    StatusService statuses,
                                    ShipClassService shipClasses,
                                    UnitClassService unitClasses,
                                    HeroService heroes,
                                    PlanetService planets,
                                    ShipClassService shipClass,
                                    ShipService ships,
                                    StarSystemService starSystems,
                                    TrooperService troopers, KafkaSender kafkaSender, NameGenerator nameGenerator, TopicsConfig topics) {
        this.alleginaces = alleginaces;
        this.statuses = statuses;
        this.shipClasses = shipClasses;
        this.unitClasses = unitClasses;
        this.heroes = heroes;
        this.planets = planets;
        this.shipClass = shipClass;
        this.ships = ships;
        this.starSystems = starSystems;
        this.troopers = troopers;
        this.kafkaSender = kafkaSender;
        this.nameGenerator = nameGenerator;
        this.topics = topics;
        this.randomElement = new RandomElementImpl();
    }

    public void generate() {
        generateAllegiances();
        generateStatuses();
        generateShipClasses();
        generateUnitClasses();
        generateStarSystems();
        generatePlanets();
        generateHeroes();
        generateFleet();
        generateUnits();
    }

    private void generateAllegiances() {
        for (Allegiances a : Allegiances.values()) {
            Allegiance allegiance = new Allegiance(a.name());
            alleginaces.save(allegiance);
            kafkaSender.sendMessage("created allegiance " + allegiance.getName(), topics.getCreationTopic());
        }
    }

    private void generateStatuses() {
        for (Statuses s : Statuses.values()) {
            Status status = new Status(s.name());
            statuses.save(status);
            kafkaSender.sendMessage("created status " + status.getName(), topics.getCreationTopic());
        }
    }

    private void generateShipClasses() {
        for (ShipClasses s : ShipClasses.values()) {
            Allegiance allegiance = alleginaces.findByName(s.getAllegiance().name());
            ShipClass shipClass = new ShipClass(s.getName(), allegiance, s.getHp(), s.getDpsMin(), s.getDpsMax());
            shipClasses.save(shipClass);
            kafkaSender.sendMessage("created ship class " + shipClass.getName(), topics.getCreationTopic());
        }
    }

    private void generateUnitClasses() {
        for (UnitClasses u : UnitClasses.values()) {
            Allegiance allegiance = alleginaces.findByName(u.getAllegiance().name());
            UnitClass unitClass = new UnitClass(u.getName(), allegiance, u.getHp(), u.getDpsMin(), u.getDpsMax());
            unitClasses.save(unitClass);
            kafkaSender.sendMessage("created unit class " + unitClass.getName(), topics.getCreationTopic());
        }
    }

    private void generateStarSystems() {
        List<Allegiance> allegianceList = alleginaces.findAll();
        for (StarSystems s : StarSystems.values()) {
            StarSystem system = new StarSystem(s.name(), randomElement.get(allegianceList));
            starSystems.save(system);
            kafkaSender.sendMessage("created star system " + system.getName(), topics.getCreationTopic());
        }
    }

    private void generatePlanets() {
        List<Allegiance> allegianceList = alleginaces.findAll();
        for (StarSystems s : StarSystems.values()) {
            StarSystem system = starSystems.findByName(s.name());
            for (Planets p : s.getPlanets()) {
                Planet planet = new Planet(p.name(), system, randomElement.get(allegianceList));
                planets.save(planet);
                kafkaSender.sendMessage("created planet " + system.getName(), topics.getCreationTopic());
            }
        }
    }

    private void generateHeroes() {
        Status active = statuses.findByName(Statuses.ACTIVE.name());
        for (Heroes h : Heroes.values()) {
            Allegiance allegiance = alleginaces.findByName(h.getAllegiance().name());
            List<Planet> planetList = planets.findAll(allegiance);
            Hero hero = new Hero(h.getName(), h.getHp(), h.getBuff(), h.getDpsMin(), h.getDpsMax(), allegiance, randomElement.get(planetList), active);
            heroes.save(hero);
            kafkaSender.sendMessage("created hero " + hero.getName(), topics.getCreationTopic());
        }
    }

    private void generateFleet() {
        Status active = statuses.findByName(Statuses.ACTIVE.name());
        for (Allegiance allegiance : alleginaces.findAll()) {
            List<StarSystem> starSystemList = starSystems.findAll(allegiance);
            List<ShipClass> shipClassList = shipClasses.findByAllegiance(allegiance);
            for (int i = 0; i < 1000; i++) {
                Ship ship = new Ship(nameGenerator.generateShipName(), randomElement.get(shipClassList), randomElement.get(starSystemList), active);
                ships.save(ship);
                kafkaSender.sendMessage("created ship " + ship.getName() + " allegiance " + allegiance.getName(), topics.getCreationTopic());
            }
        }
    }

    private void generateUnits() {
        Status active = statuses.findByName(Statuses.ACTIVE.name());
        for (Allegiance allegiance : alleginaces.findAll()) {
            List<Planet> planetList = planets.findAll(allegiance);
            List<UnitClass> unitClassList = unitClasses.findByAllegiance(allegiance);
            for (int i = 0; i < 1000; i++) {
                Unit unit = new Unit(nameGenerator.generateTrooperName(), randomElement.get(unitClassList), allegiance, randomElement.get(planetList), active);
                troopers.save(unit);
                kafkaSender.sendMessage("created unit " + unit.getName() + " allegiance " + allegiance.getName(), topics.getCreationTopic());
            }
        }
    }
}
