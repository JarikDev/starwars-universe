package cmd.starwars.universe.services;

import cmd.starwars.universe.model.Trooper;
import cmd.starwars.universe.repo.TrooperRepository;
import cmd.starwars.universe.repo.entities.TrooperDto;
import cmd.starwars.universe.services.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrooperService {
    private final TrooperRepository troopers;
    private final EntityMapper mapper;

    @Autowired
    public TrooperService(TrooperRepository troopers, EntityMapper mapper) {
        this.troopers = troopers;
        this.mapper = mapper;
    }

    public void save(Trooper Trooper) {
        TrooperDto trooperDto = mapper.toTrooperDto(Trooper);
        troopers.save(trooperDto);
    }

    public void delete(Trooper Trooper) {
        TrooperDto trooperDto = mapper.toTrooperDto(Trooper);
        troopers.delete(trooperDto);
    }

    public Trooper findById(long trooperId) {
        return troopers.findById(trooperId)
                .map(mapper::toTrooper)
                .orElse(null);
    }

    public List<Trooper> findAll() {
        return troopers.findAll().stream()
                .map(mapper::toTrooper)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
