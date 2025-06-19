package cmd.starwars.universe.services.mappers;

import cmd.starwars.universe.model.entitydto.*;
import cmd.starwars.universe.repo.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntityMapper {
    AllegianceDto toAllegianceDto(Allegiance allegiance);

    HeroDto toHeroDto(Hero heroDto);

    PlanetDto toPlanetDto(Planet planet);

    ShipClassDto toShipClassDto(ShipClass shipClass);

    @Mapping(target = "shipClass", source = "shipClass.id")
    ShipDto toShipDto(Ship ship);

    StarSystemDto toStarSystemDto(StarSystem starSystem);

    UnitDto toTrooperDto(Unit unit);

    StatusDto toStatusDto(Status status);

    UnitClassDto toUnitCLassDto(UnitClass unitClass);
}
