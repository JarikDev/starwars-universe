package cmd.starwars.universe.services.data;

import cmd.starwars.universe.repo.PlanetRepository;
import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {
    private final PlanetRepository planets;

    @Autowired
    public PlanetService(PlanetRepository planet) {
        this.planets = planet;
    }

    public void save(Planet planet) {
        planets.save(planet);
    }

    public void delete(Planet planet) {
        planets.delete(planet);
    }

    public Planet findById(long planetId) {
        return planets.findById(planetId)
                .orElse(null);
    }

    public List<Planet> findAll() {
        return planets.findAll();
    }

    public Planet findPlanetByName(String name) {
        return planets.findPlanetByName(name)
                .orElse(null);
    }

    public List<Planet> findAll(Allegiance allegiance) {
        return planets.findAllByAllegiance(allegiance);
    }
}
