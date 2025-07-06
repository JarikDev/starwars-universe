package cmd.starwars.universe.model.reports;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanetReport {
    private long id;
    private String name;
    private String allegiance;
    private String starSystem;
    private List<UnitReport> unitReports;
    private List<HeroReport> heroReports;
}
