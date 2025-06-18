package cmd.starwars.universe.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Ship {
    private Long id;
    private String name;
    private int shipClass;
    private float hp;
    private float dpsMin;
    private float dpsMax;
    private StarSystem starSystem;

    public Ship(String name, int shipClass, float hp, float dpsMin, float dpsMax, StarSystem starSystem) {
        this.name = name;
        this.shipClass = shipClass;
        this.hp = hp;
        this.dpsMin = dpsMin;
        this.dpsMax = dpsMax;
        this.starSystem = starSystem;
    }
}
