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
    @ManyToOne
    @JoinColumn(name = "ship_class_id", referencedColumnName = "id")
    private ShipClass shipClass;
    @ManyToOne
    @JoinColumn(name = "star_system_id", referencedColumnName = "id")
    private StarSystem starSystem;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public Ship(String name, ShipClass shipClass, StarSystem starSystem, Status status) {
        this.name = name;
        this.shipClass = shipClass;
        this.starSystem = starSystem;
        this.status = status;
    }
}
