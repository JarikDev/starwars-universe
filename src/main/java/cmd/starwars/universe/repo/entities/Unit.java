package cmd.starwars.universe.repo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unit_class_id", referencedColumnName = "id")
    private UnitClass unitClass;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "allegiance_id", referencedColumnName = "id")
    private Allegiance allegiance;
    @ManyToOne
    @JoinColumn(name = "planet_id", referencedColumnName = "id")
    private Planet planet;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public Unit(String name, UnitClass unitClass, Allegiance allegiance, Planet planet, Status status) {
        this.name = name;
        this.unitClass = unitClass;
        this.allegiance = allegiance;
        this.planet = planet;
        this.status = status;
    }
}
