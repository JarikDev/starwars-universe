package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.ShipClassDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipClassRepository extends JpaRepository<ShipClassDto, Long> {
}
