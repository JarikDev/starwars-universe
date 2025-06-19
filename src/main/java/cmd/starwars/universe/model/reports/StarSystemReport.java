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
public class StarSystemReport {
    private long id;
    private String name;
    private List<PlanetReport> planetReports;
    private List<ShipReport> shipReports;
}
