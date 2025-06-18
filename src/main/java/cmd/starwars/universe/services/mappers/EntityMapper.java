package cmd.starwars.universe.services.mappers;

import cmd.starwars.universe.model.*;
import cmd.starwars.universe.repo.entities.*;
import org.mapstruct.Mapper;

@Mapper
public interface EntityMapper {
    Hero toHero(HeroDto heroDto);

    HeroDto toHeroDto(Hero hero);

    Planet toPlanet(PlanetDto planetDto);

    PlanetDto toPlanetDto(Planet planet);

    ShipClass toShipClass(ShipClassDto shipClassDto);

    ShipClassDto toShipClassDto(ShipClass shipClass);

    Ship toShip(ShipDto shipDto);

    ShipDto toShipDto(Ship ship);

    StarSystem toStarSystem(StarSystemDto starSystemDto);

    StarSystemDto toStarSystemDto(StarSystem starSystem);

    Trooper toTrooper(TrooperDto trooperDto);

    TrooperDto toTrooperDto(Trooper trooper);
}
