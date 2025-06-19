package cmd.starwars.universe.model;

import cmd.starwars.universe.repo.entities.StarSystem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PlanetDto {
    private Long id;
    private String name;
    private StarSystem starSystem;
//    private List<HeroDto> heroes;
//    private List<TrooperDto> troopers;
}
