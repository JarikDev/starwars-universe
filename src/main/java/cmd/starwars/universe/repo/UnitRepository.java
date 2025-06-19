package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.Planet;
import cmd.starwars.universe.repo.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    List<Unit> findAllByPlanet(Planet planet);
}
