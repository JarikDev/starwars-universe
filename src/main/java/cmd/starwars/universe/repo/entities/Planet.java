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
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "star_system_id", referencedColumnName = "id")
    private StarSystem starSystem;
    @OneToMany(mappedBy = "planet", cascade = CascadeType.PERSIST)
    private List<Hero> heroes;
    @OneToMany(mappedBy = "planet", cascade = CascadeType.PERSIST)
    private List<Trooper> troopers;

    public Planet(String name, StarSystem starSystem, List<Hero> heroes, List<Trooper> troopers) {
        this.name = name;
        this.starSystem = starSystem;
        this.heroes = heroes;
        this.troopers = troopers;
    }
}
