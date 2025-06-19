package cmd.starwars.universe.services;

import cmd.starwars.universe.model.enums.Allegiances;
import cmd.starwars.universe.model.enums.Planets;
import cmd.starwars.universe.model.enums.StarSystems;
import cmd.starwars.universe.repo.entities.*;
import cmd.starwars.universe.services.impl.RandomElementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UniverseGeneratorService {
    private final EntityService<Allegiance> alleginaces;
    private final EntityService<Hero> heroes;
    private final EntityService<Planet> planets;
    private final EntityService<ShipClass> shipClass;
    private final EntityService<Ship> ships;
    private final EntityService<StarSystem> starSystems;
    private final EntityService<Trooper> troopers;
    private final RandomElement<Allegiance> randomAllegiance;
    private final RandomElement<Planet> randomPlanet;

    @Autowired
    public UniverseGeneratorService(EntityService<Allegiance> alleginaces, EntityService<Hero> heroes,
                                    EntityService<Planet> planets,
                                    EntityService<ShipClass> shipClass,
                                    EntityService<Ship> ships,
                                    EntityService<StarSystem> starSystems,
                                    EntityService<Trooper> troopers) {
        this.alleginaces = alleginaces;
        this.heroes = heroes;
        this.planets = planets;
        this.shipClass = shipClass;
        this.ships = ships;
        this.starSystems = starSystems;
        this.troopers = troopers;
        this.randomAllegiance = new RandomElementImpl<>();
        this.randomPlanet = new RandomElementImpl<>();
    }

    public void generate() {
        for (Allegiances a : Allegiances.values()) {
            Allegiance allegiance = new Allegiance(a.getName());
            alleginaces.save(allegiance);
        }

        for (StarSystems s : StarSystems.values()) {
            StarSystem system = new StarSystem(s.name(), Collections.emptyList(), Collections.emptyList());
            List<Planet> planets = new ArrayList<>();
            for (Planets p : s.getPlanets()) {
                Planet planet = new Planet(p.name(), system, Collections.emptyList(), Collections.emptyList());
                planets.add(planet);
            }
            system.setPlanets(planets);
            starSystems.save(system);
        }

        List<Planet> planetList = planets.findAll();
        for (int i = 0; i < 1000; i++) {
            Trooper trooper = new Trooper("Trooper " + 1, 1, randomPlanet.get(planetList));
            troopers.save(trooper);
        }
    }
}
