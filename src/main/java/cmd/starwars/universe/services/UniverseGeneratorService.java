package cmd.starwars.universe.services;

import cmd.starwars.universe.config.TopicsConfig;
import cmd.starwars.universe.model.enums.Allegiances;
import cmd.starwars.universe.model.enums.Planets;
import cmd.starwars.universe.model.enums.StarSystems;
import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.Planet;
import cmd.starwars.universe.repo.entities.StarSystem;
import cmd.starwars.universe.repo.entities.Trooper;
import cmd.starwars.universe.services.impl.RandomElementImpl;
import cmd.starwars.universe.services.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UniverseGeneratorService {
    private final AllegianceService alleginaces;
    private final HeroService heroes;
    private final PlanetService planets;
    private final ShipClassService shipClass;
    private final ShipService ships;
    private final StarSystemService starSystems;
    private final TrooperService troopers;
    private final RandomElement<Allegiance> randomAllegiance;
    private final RandomElement<Planet> randomPlanet;
    private final KafkaSender kafkaSender;
    private final NameGenerator nameGenerator;
    private final TopicsConfig topics;

    @Autowired
    public UniverseGeneratorService(AllegianceService alleginaces,
                                    HeroService heroes,
                                    PlanetService planets,
                                    ShipClassService shipClass,
                                    ShipService ships,
                                    StarSystemService starSystems,
                                    TrooperService troopers, KafkaSender kafkaSender, NameGenerator nameGenerator, TopicsConfig topics) {
        this.alleginaces = alleginaces;
        this.heroes = heroes;
        this.planets = planets;
        this.shipClass = shipClass;
        this.ships = ships;
        this.starSystems = starSystems;
        this.troopers = troopers;
        this.kafkaSender = kafkaSender;
        this.nameGenerator = nameGenerator;
        this.topics = topics;
        this.randomAllegiance = new RandomElementImpl<>();
        this.randomPlanet = new RandomElementImpl<>();
    }

    public void generate() {
        for (Allegiances a : Allegiances.values()) {
            Allegiance allegiance = new Allegiance(a.getName());
            alleginaces.save(allegiance);
            kafkaSender.sendMessage("created allegiance " + allegiance.getName(), topics.getCreationTopic());
        }
        List<Allegiance> allegianceList = alleginaces.findAll();
        for (StarSystems s : StarSystems.values()) {
            StarSystem system = new StarSystem(s.name(), Collections.emptyList(), Collections.emptyList());
            List<Planet> planets = new ArrayList<>();
            for (Planets p : s.getPlanets()) {
                Planet planet = new Planet(p.name(), system, randomAllegiance.get(allegianceList), Collections.emptyList(), Collections.emptyList());
                planets.add(planet);
            }
            system.setPlanets(planets);
            starSystems.save(system);
            kafkaSender.sendMessage("created star system " + system.getName(), topics.getCreationTopic());
        }

        List<Planet> planetList = planets.findAll();
        for (int i = 0; i < 1000; i++) {
            Trooper trooper = new Trooper(nameGenerator.generateName(), 1, randomAllegiance.get(allegianceList), randomPlanet.get(planetList));
            troopers.save(trooper);
            kafkaSender.sendMessage("created trooper " + trooper.getName(), topics.getCreationTopic());
        }
    }
}
