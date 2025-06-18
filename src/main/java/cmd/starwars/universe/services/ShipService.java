package cmd.starwars.universe.services;

import cmd.starwars.universe.model.Ship;
import cmd.starwars.universe.repo.ShipRepository;
import cmd.starwars.universe.repo.entities.ShipDto;
import cmd.starwars.universe.services.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipService {
    private final ShipRepository ships;
    private final EntityMapper mapper;

    @Autowired
    public ShipService(ShipRepository ships, EntityMapper mapper) {
        this.ships = ships;
        this.mapper = mapper;
    }

    public void save(Ship ship) {
        ShipDto shipDto = mapper.toShipDto(ship);
        ships.save(shipDto);
    }

    public void delete(Ship ship) {
        ShipDto shipDto = mapper.toShipDto(ship);
        ships.delete(shipDto);
    }

    public Ship findById(long shipId) {
        return ships.findById(shipId)
                .map(mapper::toShip)
                .orElse(null);
    }

    public List<Ship> findAll() {
        return ships.findAll().stream()
                .map(mapper::toShip)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
