package cmd.starwars.universe.rest;

import cmd.starwars.universe.model.entitydto.ShipDto;
import cmd.starwars.universe.model.messages.ActionMessage;
import cmd.starwars.universe.model.reports.*;
import cmd.starwars.universe.repo.entities.Planet;
import cmd.starwars.universe.repo.entities.Ship;
import cmd.starwars.universe.repo.entities.StarSystem;
import cmd.starwars.universe.services.UniverseGeneratorService;
import cmd.starwars.universe.services.data.*;
import cmd.starwars.universe.services.kafka.KafkaSender;
import cmd.starwars.universe.services.mappers.EntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class StarWarsUniverseController {
    private final EntityMapper mapper = Mappers.getMapper(EntityMapper.class);
    private final AllegianceService allegianceService;
    private final StatusService statusService;
    private final ShipClassService shipClassService;
    private final UnitClassService unitClassService;
    private final HeroService heroService;
    private final PlanetService planetService;
    private final ShipService shipService;
    private final StarSystemService starSystemService;
    private final UnitService unitService;
    private final UniverseGeneratorService generator;
    private final KafkaSender kafka;

    @Autowired
    public StarWarsUniverseController(AllegianceService allegianceService,
                                      StatusService statusService,
                                      ShipClassService shipClassService,
                                      UnitClassService unitClassService,
                                      HeroService heroService,
                                      PlanetService planetService,
                                      ShipService shipService,
                                      StarSystemService starSystemService,
                                      UnitService unitService,
                                      UniverseGeneratorService generator, KafkaSender kafka) {
        this.allegianceService = allegianceService;
        this.statusService = statusService;
        this.shipClassService = shipClassService;
        this.unitClassService = unitClassService;
        this.heroService = heroService;
        this.planetService = planetService;
        this.shipService = shipService;
        this.starSystemService = starSystemService;
        this.unitService = unitService;
        this.generator = generator;
        this.kafka = kafka;
    }

    @GetMapping("/test")
    public String getTest() {
        log.info("got test request");
        return "Hello World!";
    }

    @GetMapping("/ships")
    public List<ShipDto> getShipService() {
        log.info("get ships request");
        return shipService.findAll()
                .stream()
                .map(mapper::toShipDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @PostMapping("/generate")
    public void generate() {
        log.info("generate request");
        generator.generate();
    }

    @GetMapping("/star-system/{starSystemName}")
    public StarSystemReport getStarSystemStatReport(@PathVariable("starSystemName") String starSystemName) {
        StarSystem system = starSystemService.findAll(starSystemName);
        List<Planet> planets = planetService.findAll(system);
        List<Ship> ships = shipService.findAll(system);

        List<PlanetReport> planetReports = planets.stream()
                .map(planet -> {
                    List<UnitReport> unitReports = unitService.findAll(planet)
                            .stream()
                            .map(unit -> new UnitReport(unit.getId(), unit.getName(), unit.getAllegiance().getName(), unit.getUnitClass().getName(), unit.getHp(), unit.getTotalDamage(), unit.getStatus().getName()))
                            .collect(Collectors.toCollection(ArrayList::new));

                    List<HeroReport> heroReports = heroService.findAll(planet)
                            .stream()
                            .map(hero -> new HeroReport(hero.getId(), hero.getName(), hero.getAllegiance().getName(), hero.getHp(), hero.getTotalDamage(), hero.getStatus().getName()))
                            .collect(Collectors.toCollection(ArrayList::new));

                    return new PlanetReport(planet.getId(), planet.getName(), unitReports, heroReports);
                })
                .collect(Collectors.toCollection(ArrayList::new));

        List<ShipReport> shipReports = ships.stream()
                .map(ship -> new ShipReport(ship.getId(), ship.getName(), ship.getShipClass().getName(), ship.getShipClass().getAllegiance().getName(), ship.getHp(), ship.getTotalDamage(), ship.getStatus().getName()))
                .collect(Collectors.toCollection(ArrayList::new));

        return new StarSystemReport(system.getId(), system.getName(), planetReports, shipReports);
    }

    @GetMapping("/star-system")
    public List<String> getStarSystems() {
        return starSystemService.findAll()
                .stream()
                .map(StarSystem::getName)
                .collect(Collectors.toList());
    }

    @PostMapping("/message/{topic}")
    public void postMessage(@RequestBody ActionMessage msg, @PathVariable String topic) {
        try {
            kafka.sendMessage(msg, topic);
        } catch (Exception e) {
            log.error("error sending message");
        }
    }
}
