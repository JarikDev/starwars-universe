package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.StarSystemDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarSystemRepository extends JpaRepository<StarSystemDto, Long> {
}
