package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.UnitClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnitClassRepository extends JpaRepository<UnitClass, Long> {
    Optional<UnitClass> findUnitClassByName(String name);
    List<UnitClass> findUnitClassesByAllegiance(Allegiance allegiance);
}
