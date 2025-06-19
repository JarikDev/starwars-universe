package cmd.starwars.universe.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class HeroDto {
    private Long id;
    private String name;
    private float hp;
    private float buff;
    private float dpsMin;
    private float dpsMax;
//    private PlanetDto planet;
}

