package cmd.starwars.universe.model;

import cmd.starwars.universe.repo.entities.StarSystemDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Planet {
    private Long id;
    private String name;
    private StarSystemDto starSystem;
    private List<Hero> heroes;
    private List<Trooper> troopers;
}
