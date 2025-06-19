package cmd.starwars.universe.services.data;

import cmd.starwars.universe.repo.ShipClassRepository;
import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.ShipClass;
import cmd.starwars.universe.repo.entities.UnitClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipClassService {
    private final ShipClassRepository shipClasses;

    @Autowired
    public ShipClassService(ShipClassRepository shipClasses) {
        this.shipClasses = shipClasses;
    }

    public void save(ShipClass shipClass) {
        shipClasses.save(shipClass);
    }

    public void delete(ShipClass shipClass) {
        shipClasses.delete(shipClass);
    }

    public ShipClass findById(long shipClassId) {
        return shipClasses.findById(shipClassId)
                .orElse(null);
    }
    public List<ShipClass> findByAllegiance(Allegiance allegiance) {
        return shipClasses.findShipClassesByAllegiance(allegiance);
    }
    public List<ShipClass> findAll() {
        return shipClasses.findAll();
    }
}

