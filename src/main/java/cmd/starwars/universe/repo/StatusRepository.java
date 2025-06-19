package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    Optional<Status> findStatusByName(String name);
}
