package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.Planet;
import cmd.starwars.universe.repo.entities.Status;
import cmd.starwars.universe.repo.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    List<Unit> findAllByPlanet(Planet planet);

    List<Unit> findAllByPlanetAndUnitClassAllegiance(Planet planet, Allegiance allegiance);

    List<Unit> findAllByPlanetAndStatusAndUnitClassAllegiance(Planet planet, Status status, Allegiance allegiance);
}
