package cmd.starwars.universe.services.data;

import cmd.starwars.universe.repo.UnitClassRepository;
import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.UnitClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitClassService {
    private final UnitClassRepository unitClasses;

    @Autowired
    public UnitClassService(UnitClassRepository unitClasses) {
        this.unitClasses = unitClasses;
    }

    public void save(UnitClass unitClass) {
        unitClasses.save(unitClass);
    }

    public void delete(UnitClass unitClass) {
        unitClasses.delete(unitClass);
    }

    public UnitClass findById(long unitClassId) {
        return unitClasses.findById(unitClassId)
                .orElse(null);
    }

    public List<UnitClass> findByAllegiance(Allegiance allegiance) {
        return unitClasses.findUnitClassesByAllegiance(allegiance);
    }

    public List<UnitClass> findAll() {
        return unitClasses.findAll();
    }
}
