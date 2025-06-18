package cmd.starwars.universe.repo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShipDto {
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "star_system_id", referencedColumnName = "id")
    private StarSystemDto starSystem;
}
