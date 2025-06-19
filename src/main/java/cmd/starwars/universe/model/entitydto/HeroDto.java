package cmd.starwars.universe.model.entitydto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeroDto {
    private Long id;
    private String name;
    private float hp;
    private float buff;
    private float dpsMin;
    private float dpsMax;
}

