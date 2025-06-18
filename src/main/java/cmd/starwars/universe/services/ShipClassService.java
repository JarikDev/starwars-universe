package cmd.starwars.universe.services;

import cmd.starwars.universe.model.ShipClass;
import cmd.starwars.universe.repo.ShipClassRepository;
import cmd.starwars.universe.repo.entities.ShipClassDto;
import cmd.starwars.universe.services.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipClassService {
    private final ShipClassRepository shipClasses;
    private final EntityMapper mapper;
    @Autowired
    public ShipClassService(ShipClassRepository shipClasses, EntityMapper mapper) {
        this.shipClasses = shipClasses;
        this.mapper = mapper;
    }

    public void save(ShipClass shipClass) {
        ShipClassDto shipClassDto = mapper.toShipClassDto(shipClass);
        shipClasses.save(shipClassDto);
    }

    public void delete(ShipClass shipClass) {
        ShipClassDto shipClassDto = mapper.toShipClassDto(shipClass);
        shipClasses.delete(shipClassDto);
    }

    public ShipClass findById(long shipClassId) {
        return shipClasses.findById(shipClassId)
                .map(mapper::toShipClass)
                .orElse(null);
    }

    public List<ShipClass> findAll() {
        return shipClasses.findAll() .stream()
                .map(mapper::toShipClass)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}

