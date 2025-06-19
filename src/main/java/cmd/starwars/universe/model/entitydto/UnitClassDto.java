package cmd.starwars.universe.model.entitydto;

import cmd.starwars.universe.repo.entities.Allegiance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnitClassDto {
    private Long id;
    private String name;
    private Allegiance allegiance;
    private float hp;
    private float dpsMin;
    private float dpsMax;
}
