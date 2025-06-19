package cmd.starwars.universe.services;

import cmd.starwars.universe.repo.ShipRepository;
import cmd.starwars.universe.repo.entities.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {
    private final ShipRepository ships;

    @Autowired
    public ShipService(ShipRepository ships) {
        this.ships = ships;
    }

    public void save(Ship ship) {
        ships.save(ship);
    }

    public void delete(Ship ship) {
        ships.delete(ship);
    }

    public Ship findById(long shipId) {
        return ships.findById(shipId)
                .orElse(null);
    }

    public List<Ship> findAll() {
        return ships.findAll();
    }
}
