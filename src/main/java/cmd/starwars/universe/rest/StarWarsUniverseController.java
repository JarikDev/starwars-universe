package cmd.starwars.universe.rest;

import cmd.starwars.universe.model.Ship;
import cmd.starwars.universe.model.StarSystem;
import cmd.starwars.universe.model.enums.StarSystems;
import cmd.starwars.universe.services.ShipService;
import cmd.starwars.universe.services.StarSystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class StarWarsUniverseController {
    private final ShipService ships;
    private final StarSystemService starSystems;

    @Autowired
    public StarWarsUniverseController(ShipService ships, StarSystemService starSystems) {
        this.ships = ships;
        this.starSystems = starSystems;
    }

    @GetMapping("/test")
    public String getTest() {
        log.info("got test request");
        return "Hello World!";
    }

    @GetMapping("/ships")
    public List<Ship> getShips() {
        log.info("got getShips request");
        return ships.findAll();
    }

    @PostMapping("/generate")
    public void generate() {
        log.info("got generate request");
        StarSystem system = new StarSystem(StarSystems.CORUSCANT_SYSTEM.getName(),  Collections.emptyList(), Collections.emptyList());
//        starSystems.save(system);
        Ship ship = new Ship("Yamato", 1, 1000.0f, 50.0f, 100.0f, system);
        ships.save(ship);
    }
}
