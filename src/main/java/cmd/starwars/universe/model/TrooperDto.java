package cmd.starwars.universe.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TrooperDto {
    private Long id;
    private String name;
    private int classId;
//    private PlanetDto planet;
}
