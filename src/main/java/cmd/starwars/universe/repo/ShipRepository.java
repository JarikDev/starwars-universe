package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.ShipDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends JpaRepository<ShipDto, Long> {
}
