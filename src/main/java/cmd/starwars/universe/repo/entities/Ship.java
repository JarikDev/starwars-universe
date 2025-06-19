package cmd.starwars.universe.repo.entities;

import cmd.starwars.universe.model.units.Attackable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ship implements Attackable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private float hp;
    @Column
    private double totalDamage;
    @ManyToOne
    @JoinColumn(name = "ship_class_id", referencedColumnName = "id")
    private ShipClass shipClass;
    @ManyToOne
    @JoinColumn(name = "star_system_id", referencedColumnName = "id")
    private StarSystem starSystem;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public Ship(String name, float hp, ShipClass shipClass, StarSystem starSystem, Status status) {
        this.name = name;
        this.hp = hp;
        this.shipClass = shipClass;
        this.starSystem = starSystem;
        this.status = status;
    }


    @Override
    public float getDamage() {
        return getDamage(shipClass.getDpsMin(), shipClass.getDpsMax());
    }
}
