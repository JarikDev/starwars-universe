package cmd.starwars.universe.rest;

import cmd.starwars.universe.model.messages.ActionMessage;
import cmd.starwars.universe.model.reports.HeroReport;
import cmd.starwars.universe.model.reports.ShipReport;
import cmd.starwars.universe.model.reports.StarSystemReport;
import cmd.starwars.universe.services.ReportService;
import cmd.starwars.universe.services.UniverseGeneratorService;
import cmd.starwars.universe.services.data.*;
import cmd.starwars.universe.services.kafka.KafkaSender;
import cmd.starwars.universe.services.mappers.EntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<ShipReport> getShipReports() {
        log.info("get ships request");
        return reports.getShipReports();
    }

    @GetMapping("/heroes")
    public List<HeroReport> getHeroReports() {
        return reports.getHeroReports();
    }

    @PostMapping("/generate")
    public void generate() {
        log.info("generate request");
        generator.generate();
    }

    @GetMapping("/star-system/{starSystemName}")
    public StarSystemReport getStarSystemReport(@PathVariable("starSystemName") String starSystemName) {
        return reports.getStarSystemReport(starSystemName);
    }

    @GetMapping("/star-system/{starSystemName}/{allegiance}")
    public StarSystemReport getStarSystemReportWithAllegiance(@PathVariable("starSystemName") String starSystemName,
                                                              @PathVariable("allegiance") String allegianceName) {
        return reports.getStarSystemReport(starSystemName, allegianceName);
    }

    @GetMapping("/star-system")
    public List<String> getStarSystems() {
        return reports.getStarSystemsNames();
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
