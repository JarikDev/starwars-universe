package cmd.starwars.universe.rest;

import cmd.starwars.universe.model.enums.Statuses;
import cmd.starwars.universe.model.messages.ActionMessage;
import cmd.starwars.universe.model.reports.*;
import cmd.starwars.universe.repo.entities.*;
import cmd.starwars.universe.services.ReportService;
import cmd.starwars.universe.services.UniverseGeneratorService;
import cmd.starwars.universe.services.data.*;
import cmd.starwars.universe.services.kafka.KafkaSender;
import cmd.starwars.universe.services.mappers.EntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class StarWarsUniverseController {
    private final EntityMapper mapper = Mappers.getMapper(EntityMapper.class);
    private final AllegianceService allegianceService;
    private final StatusService statusService;
    private final ShipClassService shipClassService;
    private final UnitClassService unitClassService;
    private final PlanetService planetService;
    private final ShipService shipService;
    private final StarSystemService starSystemService;
    private final UnitService unitService;
    private final UniverseGeneratorService generator;
    private final KafkaSender kafka;
    private final ReportService reports;

    @Autowired
    public StarWarsUniverseController(AllegianceService allegianceService,
                                      StatusService statusService,
                                      ShipClassService shipClassService,
                                      UnitClassService unitClassService,
                                      PlanetService planetService,
                                      ShipService shipService,
                                      StarSystemService starSystemService,
                                      UnitService unitService,
                                      UniverseGeneratorService generator, KafkaSender kafka, ReportService reports) {
        this.allegianceService = allegianceService;
        this.statusService = statusService;
        this.shipClassService = shipClassService;
        this.unitClassService = unitClassService;
        this.planetService = planetService;
        this.shipService = shipService;
        this.starSystemService = starSystemService;
        this.unitService = unitService;
        this.generator = generator;
        this.kafka = kafka;
        this.reports = reports;
    }

    @GetMapping("/test")
    public String getTest() {
        log.info("got test request");
        return "Hello World!";
    }

    @GetMapping("/ships")
    public ResponseEntity<List<ShipReport>> getShipReports() {
        log.info("get ships request");
        List<ShipReport> reportList = reports.getShipReports();
        return reportList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ofNullable(reportList);
    }

    @GetMapping("/heroes")
    public ResponseEntity<List<HeroReport>> getHeroReports() {
        List<HeroReport> reportList = reports.getHeroReports();
        return reportList.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ofNullable(reportList);
    }

    @PostMapping("/generate")
    public ResponseEntity<Void> generate() {
        log.info("generate request");
        generator.generate();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/star-systems/{starSystemName}")
    public ResponseEntity<StarSystemReport> getStarSystemReport(@PathVariable("starSystemName") String starSystemName) {
        StarSystemReport report = reports.getStarSystemReport(starSystemName);
        return report == null ? ResponseEntity.noContent().build() : ResponseEntity.ofNullable(report);
    }

    @GetMapping("/planets/{planetName}/{allegiance}/{status}")
    public ResponseEntity<List<UnitReport>> getUnitsByPlanetReport(@PathVariable("planetName") String planetName,
                                                                   @PathVariable("allegiance") String allegianceName,
                                                                   @PathVariable("status") String statusName) {
        Planet planet = planetService.findByName(planetName);
        Allegiance allegiance = allegianceService.findByName(allegianceName);
        Status status = statusService.findByName(statusName);
        List<Unit> units = unitService.findAll(planet, allegiance, status);
        List<UnitReport> reports = units
                .stream()
                .map(mapper::toUnitReport)
                .collect(Collectors.toList());
        return reports.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ofNullable(reports);

    }

    @GetMapping("/planets/{planetName}")
    public ResponseEntity<PlanetReport> getPlanetReportByName(@PathVariable("planetName") String planetName) {
        PlanetReport report = Optional.ofNullable(planetService.findByName(planetName))
                .map(mapper::toPlanetReport)
                .orElse(null);
        return report == null ? ResponseEntity.noContent().build() : ResponseEntity.ofNullable(report);
    }

    @GetMapping("/star-systems/{starSystemName}/{allegiance}/{status}")
    public ResponseEntity<List<ShipReport>> getFleetByStarSystemAllegianceStatusReport(@PathVariable("starSystemName") String starSystemName,
                                                                                       @PathVariable("allegiance") String allegianceName,
                                                                                       @PathVariable("status") String statusName) {
        StarSystem system = starSystemService.findByName(starSystemName);
        Allegiance allegiance = allegianceService.findByName(allegianceName);
        Status status = statusService.findByName(statusName);
        List<Ship> ships = shipService.findAll(system, allegiance, status);
        List<ShipReport> reports = ships
                .stream()
                .map(mapper::toShipReport)
                .toList();
        return reports.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ofNullable(reports);

    }

    @GetMapping("/star-systems/contested/{allegiance}")
    public ResponseEntity<List<String>> getStarSystemsByAllegiance(@PathVariable("allegiance") String allegianceName) {
        Allegiance allegiance = allegianceService.findByName(allegianceName);
        Status status = statusService.findByName(Statuses.ACTIVE.name());

        List<String> starSystemNames = starSystemService.findAll()
                .stream()
                .filter(starSystem -> {
                    boolean hasEnemyShips = !shipService.findAll(starSystem, allegiance, status).isEmpty();
                    List<Planet> planets = planetService.findAll(starSystem);
                    boolean hasEnemyUnits = planets.stream()
                            .map(planet -> !unitService.findAll(planet, allegiance, status).isEmpty()
                            ).findFirst()
                            .orElse(false);
                    return hasEnemyShips || hasEnemyUnits;
                })
                .map(StarSystem::getName)
                .collect(Collectors.toList());
        return starSystemNames.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ofNullable(starSystemNames);
    }

    @GetMapping("/star-systems/{starSystemName}/planets")
    public ResponseEntity<List<String>> getPlanetsByStarSystem(@PathVariable("starSystemName") String starSystemName) {
        StarSystem system = starSystemService.findByName(starSystemName);
        List<String> planetNames = planetService.findAll(system).stream()
                .map(Planet::getName)
                .toList();
        return planetNames.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ofNullable(planetNames);
    }

    @GetMapping("/star-systems/{starSystemName}/{allegiance}")
    public StarSystemReport getStarSystemReportWithAllegiance(@PathVariable("starSystemName") String starSystemName,
                                                              @PathVariable("allegiance") String allegianceName) {
        return reports.getStarSystemReport(starSystemName, allegianceName);
    }

    @GetMapping("/star-systems")
    public ResponseEntity<List<String>> getStarSystems() {
        List<String> starSystemNames = reports.getStarSystemsNames();
        return starSystemNames.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ofNullable(starSystemNames);
    }

    @PostMapping("/message/{topic}")
    public ResponseEntity<Void> postMessage(@RequestBody ActionMessage msg, @PathVariable String topic) {
        try {
            kafka.sendMessage(msg, topic);
        } catch (Exception e) {
            log.error("error sending message");
        }
        return ResponseEntity.noContent().build();
    }
}
