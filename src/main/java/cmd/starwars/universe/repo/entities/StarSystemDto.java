package cmd.starwars.universe.repo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class StarSystemDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "starSystem", cascade = CascadeType.PERSIST)
    private List<PlanetDto> planets;
    @OneToMany(mappedBy = "starSystem", cascade = CascadeType.PERSIST)
    private List<ShipDto> ships;
}
