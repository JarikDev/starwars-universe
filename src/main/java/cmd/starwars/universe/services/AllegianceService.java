package cmd.starwars.universe.services;

import cmd.starwars.universe.repo.AllegianceRepository;
import cmd.starwars.universe.repo.entities.Allegiance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllegianceService {
    private final AllegianceRepository allegiances;

    @Autowired
    public AllegianceService(AllegianceRepository allegiances) {
        this.allegiances = allegiances;
    }

    public void save(Allegiance allegiance) {
        allegiances.save(allegiance);
    }

    public void delete(Allegiance allegiance) {
        allegiances.delete(allegiance);
    }

    public Allegiance findById(long allegianceId) {
        return allegiances.findById(allegianceId)
                .orElse(null);
    }

    public List<Allegiance> findAll() {
        return allegiances.findAll();
    }
}
