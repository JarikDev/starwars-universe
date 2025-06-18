package cmd.starwars.universe.services;

import cmd.starwars.universe.model.Planet;
import cmd.starwars.universe.repo.PlanetRepository;
import cmd.starwars.universe.repo.entities.PlanetDto;
import cmd.starwars.universe.services.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanetService {
    private final PlanetRepository planets;
    private final EntityMapper mapper;

    @Autowired
    public PlanetService(PlanetRepository planet, EntityMapper mapper) {
        this.planets = planet;
        this.mapper = mapper;
    }

    public void save(Planet planet) {
        PlanetDto planetDto = mapper.toPlanetDto(planet);
        planets.save(planetDto);
    }

    public void delete(Planet planet) {
        PlanetDto planetDto = mapper.toPlanetDto(planet);
        planets.delete(planetDto);
    }

    public Planet findById(long planetId) {
        return planets.findById(planetId)
                .map(mapper::toPlanet)
                .orElse(null);
    }

    public List<Planet> findAll() {
        return planets
                .findAll()
                .stream()
                .map(mapper::toPlanet)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
