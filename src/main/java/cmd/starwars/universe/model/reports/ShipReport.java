package cmd.starwars.universe.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShipReport {
    private long id;
    private String name;
    private String allegiance;
    private String shipClass;
    private String starSystem;
    private float hp;
    private double totalDamage;
    private String status;
}
