package cmd.starwars.universe.repo;

import cmd.starwars.universe.repo.entities.HeroDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<HeroDto, Long> {
}
