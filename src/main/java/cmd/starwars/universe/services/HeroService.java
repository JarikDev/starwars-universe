package cmd.starwars.universe.services;

import cmd.starwars.universe.model.Hero;
import cmd.starwars.universe.repo.HeroRepository;
import cmd.starwars.universe.repo.entities.HeroDto;
import cmd.starwars.universe.services.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroService {
    private final HeroRepository heroes;
    private final EntityMapper mapper;

    @Autowired
    public HeroService(HeroRepository heroes, EntityMapper mapper) {
        this.heroes = heroes;
        this.mapper = mapper;
    }

    public void save(Hero hero) {
        HeroDto heroDto = mapper.toHeroDto(hero);
        heroes.save(heroDto);
    }

    public void delete(Hero hero) {
        HeroDto heroDto = mapper.toHeroDto(hero);
        heroes.delete(heroDto);
    }

    public Hero findById(long heroId) {
        return heroes.findById(heroId)
                .map(mapper::toHero)
                .orElse(null);
    }

    public List<Hero> findAll() {
        return heroes
                .findAll()
                .stream()
                .map(mapper::toHero)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
