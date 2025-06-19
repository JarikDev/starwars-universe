package cmd.starwars.universe.services.data;

import cmd.starwars.universe.repo.HeroRepository;
import cmd.starwars.universe.repo.entities.Hero;
import cmd.starwars.universe.repo.entities.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {
    private final HeroRepository heroes;

    @Autowired
    public HeroService(HeroRepository heroes) {
        this.heroes = heroes;
    }

    public void save(Hero hero) {
        heroes.save(hero);
    }

    public void delete(Hero hero) {
        heroes.delete(hero);
    }

    public Hero findById(long heroId) {
        return heroes.findById(heroId)
                .orElse(null);
    }

    public List<Hero> findAll() {
        return heroes.findAll();
    }

    public List<Hero> findAll(Planet planet) {
        return heroes.findAllByPlanet(planet);
    }
}
