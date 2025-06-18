package cmd.starwars.universe.services;

import cmd.starwars.universe.model.StarSystem;
import cmd.starwars.universe.repo.StarSystemRepository;
import cmd.starwars.universe.repo.entities.StarSystemDto;
import cmd.starwars.universe.services.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarSystemService {
    private final StarSystemRepository starSystems;
    private final EntityMapper mapper;

    @Autowired
    public StarSystemService(StarSystemRepository starSystems, EntityMapper mapper) {
        this.starSystems = starSystems;
        this.mapper = mapper;
    }

    public void save(StarSystem StarSystem) {
        StarSystemDto StarSystemDto = mapper.toStarSystemDto(StarSystem);
        starSystems.save(StarSystemDto);
    }

    public void delete(StarSystem StarSystem) {
        StarSystemDto StarSystemDto = mapper.toStarSystemDto(StarSystem);
        starSystems.delete(StarSystemDto);
    }

    public StarSystem findById(long StarSystemId) {
        return starSystems.findById(StarSystemId)
                .map(mapper::toStarSystem)
                .orElse(null);
    }

    public List<StarSystem> findAll() {
        return starSystems.findAll().stream()
                .map(mapper::toStarSystem)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
