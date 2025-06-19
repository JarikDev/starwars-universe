package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.Allegiance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllegianceRepository extends JpaRepository<Allegiance, Long> {
}
