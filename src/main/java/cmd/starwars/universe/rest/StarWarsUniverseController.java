package cmd.starwars.universe.rest;

import cmd.starwars.universe.model.ShipDto;
import cmd.starwars.universe.repo.entities.*;
import cmd.starwars.universe.services.EntityService;
import cmd.starwars.universe.services.UniverseGeneratorService;
import cmd.starwars.universe.services.mappers.EntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
public class StarWarsUniverseController {
    private final EntityMapper mapper = Mappers.getMapper(EntityMapper.class);
    private final EntityService<Allegiance> alleginaces;
    private final EntityService<Hero> heroes;
    private final EntityService<Planet> planets;
    private final EntityService<ShipClass> shipClass;
    private final EntityService<Ship> ships;
    private final EntityService<StarSystem> starSystems;
    private final EntityService<Trooper> troopers;
    private final UniverseGeneratorService generator;

    @Autowired
    public StarWarsUniverseController(EntityService<Allegiance> alleginaces, EntityService<Hero> heroes,
                                      EntityService<Planet> planets,
                                      EntityService<ShipClass> shipClass,
                                      EntityService<Ship> ships,
                                      EntityService<StarSystem> starSystems,
                                      EntityService<Trooper> troopers, UniverseGeneratorService generator) {
        this.alleginaces = alleginaces;
        this.heroes = heroes;
        this.planets = planets;
        this.shipClass = shipClass;
        this.ships = ships;
        this.starSystems = starSystems;
        this.troopers = troopers;
        this.generator = generator;
    }

    @GetMapping("/test")
    public String getTest() {
        log.info("got test request");
        return "Hello World!";
    }

    @GetMapping("/ships")
    public List<ShipDto> getShips() {
        log.info("get ships request");
        return ships.findAll()
                .stream()
                .map(mapper::toShipDto)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @PostMapping("/generate")
    public void generate() {
        log.info("generate request");
        generator.generate();
//        StarSystem system = new StarSystem(StarSystems.CORUSCANT_SYSTEM.getName(), Collections.emptyList(), Collections.emptyList());
//        Ship ship = new Ship("Yamato", 1, 1000.0f, 50.0f, 100.0f, system);
//        ships.save(ship);
    }
}
