package cmd.starwars.universe.repo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private int shipClass;
    @Column
    private float hp;
    @Column
    private float dpsMin;
    @Column
    private float dpsMax;
    @ManyToOne
    @JoinColumn(name = "allegiance_id", referencedColumnName = "id")
    private Allegiance allegiance;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "star_system_id", referencedColumnName = "id")
    private StarSystem starSystem;

    public Ship(String name, int shipClass, float hp, float dpsMin, float dpsMax,Allegiance allegiance, StarSystem starSystem) {
        this.name = name;
        this.shipClass = shipClass;
        this.hp = hp;
        this.dpsMin = dpsMin;
        this.dpsMax = dpsMax;
        this.allegiance = allegiance;
        this.starSystem = starSystem;
    }
}
