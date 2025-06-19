package cmd.starwars.universe.services.data;

import cmd.starwars.universe.repo.TrooperRepository;
import cmd.starwars.universe.repo.entities.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrooperService {
    private final TrooperRepository troopers;

    @Autowired
    public TrooperService(TrooperRepository troopers) {
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
}
