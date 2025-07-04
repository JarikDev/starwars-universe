package cmd.starwars.universe.repo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StarSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "allegiance_id", referencedColumnName = "id")
    private Allegiance allegiance;

    public StarSystem(String name, Allegiance allegiance) {
        this.name = name;
        this.allegiance = allegiance;
    }
}
