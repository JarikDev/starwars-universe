package cmd.starwars.universe.services.data;

import cmd.starwars.universe.repo.UnitRepository;
import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.Planet;
import cmd.starwars.universe.repo.entities.Status;
import cmd.starwars.universe.repo.entities.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitService {
    private final UnitRepository troopers;

    @Autowired
    public UnitService(UnitRepository troopers) {
        this.troopers = troopers;
    }

    public void save(Unit unit) {
        troopers.save(unit);
    }

    public void delete(Unit unit) {
        troopers.delete(unit);
    }

    public Unit findById(long trooperId) {
        return troopers.findById(trooperId)
                .orElse(null);
    }

    public List<Unit> findAll() {
        return troopers.findAll();
    }

    public List<Unit> findAll(Planet planet) {
        return troopers.findAllByPlanet(planet);
    }

    public List<Unit> findAll(Planet planet, Allegiance allegiance) {
        return troopers.findAllByPlanetAndUnitClassAllegiance(planet, allegiance);
    }

    public List<Unit> findAll(Planet planet, Allegiance allegiance, Status status) {
        return troopers.findAllByPlanetAndStatusAndUnitClassAllegiance(planet, status, allegiance);
    }
}
