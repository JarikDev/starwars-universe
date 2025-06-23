package cmd.starwars.universe.services.mappers;

import cmd.starwars.universe.model.entitydto.*;
import cmd.starwars.universe.model.reports.HeroReport;
import cmd.starwars.universe.model.reports.ShipReport;
import cmd.starwars.universe.model.reports.UnitReport;
import cmd.starwars.universe.repo.entities.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntityMapper {
    AllegianceDto toAllegianceDto(Allegiance allegiance);

    HeroDto toHeroDto(Unit heroDto);

    PlanetDto toPlanetDto(Planet planet);

    ShipClassDto toShipClassDto(ShipClass shipClass);

    @Mapping(target = "shipClass", source = "shipClass.name")
    ShipDto toShipDto(Ship ship);

    StarSystemDto toStarSystemDto(StarSystem starSystem);

    UnitDto toTrooperDto(Unit unit);

    StatusDto toStatusDto(Status status);

    UnitClassDto toUnitCLassDto(UnitClass unitClass);

    @Mapping(target = "shipClass", source = "shipClass.name")
    @Mapping(target = "starSystem", source = "starSystem.name")
    @Mapping(target = "status", source = "status.name")
    @Mapping(target = "allegiance", source = "shipClass.allegiance.name")
    ShipReport toShipReport(Ship ship);

    @Mapping(target = "allegiance", source = "unitClass.allegiance.name")
    @Mapping(target = "buff", source = "unitClass.buff")
    @Mapping(target = "planet", source = "planet.name")
    @Mapping(target = "status", source = "status.name")
    HeroReport toHeroReport(Unit unit);

    @Mapping(target = "unitClass", source = "unitClass.name")
    @Mapping(target = "allegiance", source = "unitClass.allegiance.name")
    @Mapping(target = "planet", source = "planet.name")
    @Mapping(target = "status", source = "status.name")
    UnitReport toUnitReport(Unit unit);
}
