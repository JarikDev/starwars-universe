package cmd.starwars.universe.repo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class PlanetDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "star_system_id", referencedColumnName = "id")
    private StarSystemDto starSystem;
    @OneToMany(mappedBy = "planet", cascade = CascadeType.PERSIST)
    private List<HeroDto> heroes;
    @OneToMany(mappedBy = "planet", cascade = CascadeType.PERSIST)
    private List<TrooperDto> troopers;
}
