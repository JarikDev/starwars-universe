package cmd.starwars.universe.repo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "star_system_id", referencedColumnName = "id")
    private StarSystem starSystem;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "allegiance_id", referencedColumnName = "id")
    private Allegiance allegiance;

    public Planet(String name, StarSystem starSystem, Allegiance allegiance) {
        this.name = name;
        this.starSystem = starSystem;
        this.allegiance = allegiance;
    }
}
