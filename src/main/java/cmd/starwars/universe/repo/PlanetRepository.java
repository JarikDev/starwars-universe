package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.Planet;
import cmd.starwars.universe.repo.entities.StarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
    Optional<Planet> findPlanetByName(String name);

    List<Planet> findAllByAllegiance(Allegiance allegiance);
    List<Planet> findAllByStarSystem(StarSystem starSystem);
}
