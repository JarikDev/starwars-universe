package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.ShipClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipClassRepository extends JpaRepository<ShipClass, Long> {
    Optional<ShipClass> findShipClassByName(String name);

    List<ShipClass> findShipClassesByAllegiance(Allegiance allegiance);
}
