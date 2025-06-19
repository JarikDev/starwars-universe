package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.StarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StarSystemRepository extends JpaRepository<StarSystem, Long> {
    Optional<StarSystem> findStarSystemByName(String name);

    List<StarSystem> findStarSystemByAllegiance(Allegiance allegiance);
}
