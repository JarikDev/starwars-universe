package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.Allegiance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AllegianceRepository extends JpaRepository<Allegiance, Long> {
    Optional<Allegiance> findAllegianceByName(String name);
}
