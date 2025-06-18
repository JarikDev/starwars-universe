package cmd.starwars.universe.repo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TrooperDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private int classId;
    @ManyToOne
    @JoinColumn(name = "planet_id", referencedColumnName = "id")
    private PlanetDto planet;
}
