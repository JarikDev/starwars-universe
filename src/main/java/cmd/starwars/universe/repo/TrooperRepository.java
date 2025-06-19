package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrooperRepository extends JpaRepository<Unit, Long> {
}
