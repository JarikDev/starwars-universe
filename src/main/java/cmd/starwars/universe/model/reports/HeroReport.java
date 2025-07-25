package cmd.starwars.universe.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HeroReport {
    private long id;
    private String name;
    private String allegiance;
    private String planet;
    private float hp;
    private float buff;
    private double totalDamage;
    private String status;
}
