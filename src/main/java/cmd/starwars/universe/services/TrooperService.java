package cmd.starwars.universe.services;

import cmd.starwars.universe.repo.TrooperRepository;
import cmd.starwars.universe.repo.entities.Trooper;
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

    public void save(Trooper trooper) {
        troopers.save(trooper);
    }

    public void delete(Trooper trooper) {
        troopers.delete(trooper);
    }

    public Trooper findById(long trooperId) {
        return troopers.findById(trooperId)
                .orElse(null);
    }

    public List<Trooper> findAll() {
        return troopers.findAll();
    }
}
