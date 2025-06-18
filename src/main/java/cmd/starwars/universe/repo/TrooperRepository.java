package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.TrooperDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrooperRepository extends JpaRepository<TrooperDto, Long> {
}
