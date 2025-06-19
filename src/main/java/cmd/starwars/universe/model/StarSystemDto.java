package cmd.starwars.universe.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StarSystemDto {
    private Long id;
    private String name;
//    private List<PlanetDto> planets;
//    private List<ShipDto> ships;

    public StarSystemDto(String name ) {
        this.name = name;
//        this.planets = planetDtos;
//        this.ships = shipDtos;
    }
}
