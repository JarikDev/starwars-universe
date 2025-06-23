package cmd.starwars.universe.services;

import cmd.starwars.universe.model.reports.*;
import cmd.starwars.universe.repo.entities.Allegiance;
import cmd.starwars.universe.repo.entities.Planet;
import cmd.starwars.universe.repo.entities.Ship;
import cmd.starwars.universe.repo.entities.StarSystem;
import cmd.starwars.universe.services.data.*;
import cmd.starwars.universe.services.mappers.EntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final EntityMapper mapper = Mappers.getMapper(EntityMapper.class);
    private final AllegianceService allegianceService;
    private final StatusService statusService;
    private final ShipClassService shipClassService;
    private final UnitClassService unitClassService;
    private final PlanetService planetService;
    private final ShipService shipService;
    private final StarSystemService starSystemService;
    private final UnitService unitService;

    public ReportService(AllegianceService allegianceService,
                         StatusService statusService,
                         ShipClassService shipClassService,
                         UnitClassService unitClassService,
                         PlanetService planetService,
                         ShipService shipService,
                         StarSystemService starSystemService,
                         UnitService unitService) {
        this.allegianceService = allegianceService;
        this.statusService = statusService;
        this.shipClassService = shipClassService;
        this.unitClassService = unitClassService;
        this.planetService = planetService;
        this.shipService = shipService;
        this.starSystemService = starSystemService;
        this.unitService = unitService;
    }

    public StarSystemReport getStarSystemReport(String starSystemName) {
        StarSystem system = starSystemService.findAll(starSystemName);
        List<Planet> planets = planetService.findAll(system);
        List<Ship> ships = shipService.findAll(system);

        List<PlanetReport> planetReports = planets.stream()
                .map(planet -> {
                    List<UnitReport> unitReports = unitService.findAll(planet)
                            .stream()
                            .map(mapper::toUnitReport)
                            .collect(Collectors.toCollection(ArrayList::new));

                    List<HeroReport> heroReports = unitService.findAll(planet)
                            .stream()
                            .map(mapper::toHeroReport)
                            .collect(Collectors.toCollection(ArrayList::new));

                    return new PlanetReport(planet.getId(), planet.getName(), unitReports, heroReports);
                })
                .collect(Collectors.toCollection(ArrayList::new));

        List<ShipReport> shipReports = ships.stream()
                .map(mapper::toShipReport)
                .collect(Collectors.toCollection(ArrayList::new));

        return new StarSystemReport(system.getId(), system.getName(), planetReports, shipReports);
    }

    public StarSystemReport getStarSystemReport(String starSystemName, String allegianceName) {
        StarSystem system = starSystemService.findAll(starSystemName);
        List<Planet> planets = planetService.findAll(system);
        List<Ship> ships = shipService.findAll(system);
        Allegiance allegiance = allegianceService.findByName(allegianceName);
        List<PlanetReport> planetReports = planets.stream()
                .map(planet -> {
                    List<UnitReport> unitReports = unitService.findAll(planet)
                            .stream()
                            .filter(unit -> unit.getUnitClass().getBuff() <= 1.0f)
                            .filter(unit -> unit.getUnitClass().getAllegiance().equals(allegiance))
                            .map(mapper::toUnitReport)
                            .collect(Collectors.toCollection(ArrayList::new));

                    List<HeroReport> heroReports = unitService.findAll(planet)
                            .stream()
                            .filter(unit -> unit.getUnitClass().getBuff() > 1.0f)
                            .filter(hero -> hero.getUnitClass().getAllegiance().equals(allegiance))
                            .map(mapper::toHeroReport)
                            .collect(Collectors.toCollection(ArrayList::new));

                    return new PlanetReport(planet.getId(), planet.getName(), unitReports, heroReports);
                })
                .collect(Collectors.toCollection(ArrayList::new));

        List<ShipReport> shipReports = ships.stream()
                .filter(ship -> ship.getShipClass().getAllegiance().equals(allegiance))
                .map(mapper::toShipReport)
                .collect(Collectors.toCollection(ArrayList::new));

        return new StarSystemReport(system.getId(), system.getName(), planetReports, shipReports);
    }

    public List<String> getStarSystemsNames() {
        return starSystemService.findAll()
                .stream()
                .map(StarSystem::getName)
                .collect(Collectors.toList());
    }

    public List<ShipReport> getShipReports() {
        return shipService.findAll()
                .stream()
                .map(mapper::toShipReport)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<HeroReport> getHeroReports() {
        return unitService.findAll()
                .stream()
                .filter(unit -> unit.getUnitClass().getBuff() > 1.0f)
                .map(mapper::toHeroReport)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
