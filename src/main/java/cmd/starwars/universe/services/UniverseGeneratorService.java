package cmd.starwars.universe.services;

import cmd.starwars.universe.config.TopicsConfig;
import cmd.starwars.universe.model.enums.*;
import cmd.starwars.universe.repo.entities.*;
import cmd.starwars.universe.services.data.*;
import cmd.starwars.universe.services.impl.RandomElementImpl;
import cmd.starwars.universe.services.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniverseGeneratorService {
    private final AllegianceService allegiances;
    private final StatusService statuses;
    private final ShipClassService shipClasses;
    private final UnitClassService unitClasses;
    private final PlanetService planets;
    private final ShipService ships;
    private final StarSystemService starSystems;
    private final UnitService units;
    private final RandomElement randomElement;
    private final KafkaSender kafkaSender;
    private final NameGenerator nameGenerator;
    private final TopicsConfig topics;

    @Autowired
    public UniverseGeneratorService(AllegianceService allegiances,
                                    StatusService statuses,
                                    ShipClassService shipClasses,
                                    UnitClassService unitClasses,
                                    PlanetService planets,
                                    ShipService ships,
                                    StarSystemService starSystems,
                                    UnitService units,
                                    KafkaSender kafkaSender,
                                    NameGenerator nameGenerator,
                                    TopicsConfig topics) {
        this.allegiances = allegiances;
        this.statuses = statuses;
        this.shipClasses = shipClasses;
        this.unitClasses = unitClasses;
        this.planets = planets;
        this.ships = ships;
        this.starSystems = starSystems;
        this.units = units;
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
        generateFleet(1000000.0);
        generateUnits(10000.0);
    }

    private void generateAllegiances() {
        for (Allegiances a : Allegiances.values()) {
            Allegiance allegiance = new Allegiance(a.name());
            allegiances.save(allegiance);
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
            Allegiance allegiance = allegiances.findByName(s.getAllegiance().name());
            ShipClass shipClass = new ShipClass(s.name(), allegiance, s.getHp(), s.getDpsMin(), s.getDpsMax());
            shipClasses.save(shipClass);
            kafkaSender.sendMessage("created ship class " + shipClass.getName(), topics.getCreationTopic());
        }
    }

    private void generateUnitClasses() {
        for (UnitClasses u : UnitClasses.values()) {
            Allegiance allegiance = allegiances.findByName(u.getAllegiance().name());
            UnitClass unitClass = new UnitClass(u.name(), allegiance, u.getHp(), u.getDpsMin(), u.getDpsMax());
            unitClasses.save(unitClass);
            kafkaSender.sendMessage("created unit class " + unitClass.getName(), topics.getCreationTopic());
        }
    }

    private void generateStarSystems() {
        List<Allegiance> allegianceList = allegiances.findAll();
        for (StarSystems s : StarSystems.values()) {
            StarSystem system = new StarSystem(s.name(), randomElement.get(allegianceList));
            starSystems.save(system);
            kafkaSender.sendMessage("created star system " + system.getName(), topics.getCreationTopic());
        }
    }

    private void generatePlanets() {
        List<Allegiance> allegianceList = allegiances.findAll();
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
            Allegiance allegiance = allegiances.findByName(h.getUnitClass().getAllegiance().name());
            List<Planet> planetList = planets.findAll(allegiance);
            UnitClass unitClass = unitClasses.findByName(h.getUnitClass().name());
            Unit unit = new Unit(h.getName(), h.getUnitClass().getHp(), unitClass, randomElement.get(planetList), active);
            units.save(unit);
            kafkaSender.sendMessage("created hero " + unit.getName(), topics.getCreationTopic());
        }
    }

    private void generateFleet(double totalHp) {
        Status active = statuses.findByName(Statuses.ACTIVE.name());
        for (Allegiance allegiance : allegiances.findAll()) {
            double hpLeft = totalHp;
            List<StarSystem> starSystemList = starSystems.findAll(allegiance);
            List<ShipClass> shipClassList = shipClasses.findByAllegiance(allegiance);
            while (hpLeft > 0) {
                ShipClass shipClass = randomElement.get(shipClassList);
                Ship ship = new Ship(nameGenerator.generateShipName(), shipClass.getHp(), shipClass, randomElement.get(starSystemList), active);
                ships.save(ship);
                kafkaSender.sendMessage("created ship " + ship.getName() + " allegiance " + allegiance.getName(), topics.getCreationTopic());
                hpLeft -= shipClass.getHp();
            }
        }
    }

    private void generateUnits(double totalHp) {
        Status active = statuses.findByName(Statuses.ACTIVE.name());
        for (Allegiance allegiance : allegiances.findAll()) {
            double hpLeft = totalHp;
            List<Planet> planetList = planets.findAll(allegiance);
            List<UnitClass> unitClassList = unitClasses.findByAllegiance(allegiance)
                    .stream()
                    .filter(uc -> uc.getBuff() <= 1.0f)
                    .collect(Collectors.toCollection(ArrayList::new));
            while (hpLeft > 0) {
                UnitClass unitClass = randomElement.get(unitClassList);
                Unit unit = new Unit(nameGenerator.generateTrooperName(), unitClass.getHp(), unitClass, randomElement.get(planetList), active);
                units.save(unit);
                kafkaSender.sendMessage("created unit " + unit.getName() + " allegiance " + allegiance.getName(), topics.getCreationTopic());
                hpLeft -= unitClass.getHp();
            }
        }
    }
}
