package cmd.starwars.universe.services.data;

import cmd.starwars.universe.repo.StarSystemRepository;
import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.StarSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarSystemService {
    private final StarSystemRepository starSystems;

    @Autowired
    public StarSystemService(StarSystemRepository starSystems) {
        this.starSystems = starSystems;
    }

    public void save(StarSystem starSystem) {
        starSystems.save(starSystem);
    }

    public void delete(StarSystem starSystem) {
        starSystems.delete(starSystem);
    }

    public StarSystem findById(long starSystemId) {
        return starSystems.findById(starSystemId)
                .orElse(null);
    }

    public StarSystem findByName(String name) {
        return starSystems.findStarSystemByName(name)
                .orElse(null);
    }

    public List<StarSystem> findAll() {
        return starSystems.findAll();
    }

    public List<StarSystem> findAll(Allegiance allegiance) {
        return starSystems.findStarSystemByAllegiance(allegiance);
    }
}
