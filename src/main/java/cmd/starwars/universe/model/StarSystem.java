package cmd.starwars.universe.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StarSystem {
    private Long id;
    private String name;
    private List<Planet> planets;
    private List<Ship> ships;

    public StarSystem(String name, List<Planet> planets, List<Ship> ships) {
        this.name = name;
        this.planets = planets;
        this.ships = ships;
    }
}
