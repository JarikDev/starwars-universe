package cmd.starwars.universe.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UnitReport {
    private long id;
    private String name;
    private String allegiance;
    private String unitClass;
    private String planet;
    private float hp;
    private double totalDamage;
    private String status;
}
