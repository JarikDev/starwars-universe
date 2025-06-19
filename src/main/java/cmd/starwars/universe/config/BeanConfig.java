package cmd.starwars.universe.config;

import cmd.starwars.universe.repo.entities.*;
import cmd.starwars.universe.services.EntityService;
import cmd.starwars.universe.services.impl.EntityServiceImpl;
import cmd.starwars.universe.services.mappers.EntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

@Configuration
public class BeanConfig {
    @Bean
    public EntityMapper getEntityMapper() {
        return Mappers.getMapper(EntityMapper.class);
    }

    @Bean
    public EntityService<Allegiance> getAllegianceEntityService(JpaRepository<Allegiance, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public EntityService<Hero> getHeroEntityService(JpaRepository<Hero, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public EntityService<Planet> getPlanetEntityService(JpaRepository<Planet, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public EntityService<ShipClass> getShipClassEntityService(JpaRepository<ShipClass, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public EntityService<Ship> getShipEntityService(JpaRepository<Ship, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public EntityService<StarSystem> getStarSystemEntityService(JpaRepository<StarSystem, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }

    @Bean
    public EntityService<Trooper> getTrooperEntityService(JpaRepository<Trooper, Long> repo) {
        return new EntityServiceImpl<>(repo);
    }
}
