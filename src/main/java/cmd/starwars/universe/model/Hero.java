package cmd.starwars.universe.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Hero {
    private Long id;
    private String name;
    private float hp;
    private float buff;
    private float dpsMin;
    private float dpsMax;
    private Planet planet;

//
//    public Hero() {
//    }
//
//    public Hero(Long id, String name, int hp, int buff, int dpsMin, int dpsMax) {
//        this.id = id;
//        this.name = name;
//        this.hp = hp;
//        this.buff = buff;
//        this.dpsMin = dpsMin;
//        this.dpsMax = dpsMax;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getHp() {
//        return hp;
//    }
//
//    public void setHp(int hp) {
//        this.hp = hp;
//    }
//
//    public int getBuff() {
//        return buff;
//    }
//
//    public void setBuff(int buff) {
//        this.buff = buff;
//    }
//
//    public int getDpsMin() {
//        return dpsMin;
//    }
//
//    public void setDpsMin(int dpsMin) {
//        this.dpsMin = dpsMin;
//    }
//
//    public int getDpsMax() {
//        return dpsMax;
//    }
//
//    public void setDpsMax(int dpsMax) {
//        this.dpsMax = dpsMax;
//    }
}

