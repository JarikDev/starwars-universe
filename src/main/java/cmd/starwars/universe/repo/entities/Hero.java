package cmd.starwars.universe.repo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private float hp;
    @Column
    private float buff;
    @Column
    private float dpsMin;
    @Column
    private float dpsMax;
    @ManyToOne
    @JoinColumn(name = "allegiance_id", referencedColumnName = "id")
    private Allegiance allegiance;
    @ManyToOne
    @JoinColumn(name = "planet_id", referencedColumnName = "id")
    private Planet planet;
    @ManyToOne
    @JoinColumn(name="status_id",referencedColumnName = "id")
    private Status status;

    public Hero(String name,
                float hp,
                float buff,
                float dpsMin,
                float dpsMax,
                Allegiance allegiance,
                Planet planet,
                Status status) {
        this.name = name;
        this.hp = hp;
        this.buff = buff;
        this.dpsMin = dpsMin;
        this.dpsMax = dpsMax;
        this.allegiance = allegiance;
        this.planet = planet;
        this.status = status;
    }
}
