package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.Ship;
import cmd.starwars.universe.repo.entities.StarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    List<Ship> findAllByStarSystem(StarSystem starSystem);
}
