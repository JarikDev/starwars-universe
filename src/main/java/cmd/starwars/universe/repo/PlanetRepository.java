package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.PlanetDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<PlanetDto, Long> {
}
