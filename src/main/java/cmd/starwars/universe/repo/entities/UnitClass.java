package cmd.starwars.universe.repo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UnitClass {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "allegiance_id", referencedColumnName = "id")
    private Allegiance allegiance;
    @Column
    private float hp;
    @Column
    private float dpsMin;
    @Column
    private float dpsMax;

    public UnitClass(String name, Allegiance allegiance, float hp, float dpsMin, float dpsMax) {
        this.name = name;
        this.allegiance = allegiance;
        this.hp = hp;
        this.dpsMin = dpsMin;
        this.dpsMax = dpsMax;
    }
}
