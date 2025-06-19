package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.Hero;
import cmd.starwars.universe.repo.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
    Optional<Hero> findHeroByName(String name);

    List<Hero> findAllByPlanet(Planet planet);
}
