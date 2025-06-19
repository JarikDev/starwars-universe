package cmd.starwars.universe.repo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StarSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "starSystem", cascade = CascadeType.PERSIST)
    private List<Planet> planets;
    @OneToMany(mappedBy = "starSystem", cascade = CascadeType.PERSIST)
    private List<Ship> ships;

    public StarSystem(String name, List<Planet> planets, List<Ship> ships) {
        this.name = name;
        this.planets = planets;
        this.ships = ships;
    }
}
