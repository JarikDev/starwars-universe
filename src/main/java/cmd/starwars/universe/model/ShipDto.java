package cmd.starwars.universe.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShipDto {
    private Long id;
    private String name;
    private int shipClass;
    private float hp;
    private float dpsMin;
    private float dpsMax;
//    private StarSystemDto starSystem;

    public ShipDto(String name, int shipClass, float hp, float dpsMin, float dpsMax ) {
        this.name = name;
        this.shipClass = shipClass;
        this.hp = hp;
        this.dpsMin = dpsMin;
        this.dpsMax = dpsMax;
//        this.starSystem = starSystemDto;
    }
}
