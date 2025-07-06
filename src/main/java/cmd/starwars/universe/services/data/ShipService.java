package cmd.starwars.universe.services.data;

import cmd.starwars.universe.repo.ShipRepository;
import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.Ship;
import cmd.starwars.universe.repo.entities.StarSystem;
import cmd.starwars.universe.repo.entities.Status;
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

    public List<Ship> findAll(StarSystem starSystem) {
        return ships.findAllByStarSystem(starSystem);
    }

    public List<Ship> findAll(StarSystem starSystem, Allegiance allegiance, Status status) {
        return ships.findAllByStarSystemAndStatusAndShipClassAllegiance(starSystem, status, allegiance);
    }

    public List<Ship> findAll() {
        return ships.findAll();
    }
}
