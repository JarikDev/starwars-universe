package cmd.starwars.universe.model.entitydto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnitDto {
    private Long id;
    private String name;
    private int classId;
}
