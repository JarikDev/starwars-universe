package cmd.starwars.universe.model.enums;

import lombok.Getter;

@Getter
public enum UnitClasses {
    CLONE("Clone trooper", Allegiances.REPUBLIC, 100.0f, 20.0f, 50.0f),
    CLONE_COMMANDO("Clone commando trooper", Allegiances.REPUBLIC, 150.0f, 30.0f, 75.0f),

    B_1("B 1 battle droid", Allegiances.SEPARATIST, 100.0f, 20.0f, 50.0f),
    B_2("B 2 battle droid", Allegiances.SEPARATIST, 150.0f, 30.0f, 75.0f),
    DROIDEKA("Droideka", Allegiances.SEPARATIST, 200.0f, 40.0f, 75.0f),
    ;
    private final String name;
    private final Allegiances allegiance;
    private final float hp;
    private final float dpsMin;
    private final float dpsMax;

    UnitClasses(String name, Allegiances allegiance, float hp, float dpsMin, float dpsMax) {
        this.name = name;
        this.allegiance = allegiance;
        this.hp = hp;
        this.dpsMin = dpsMin;
        this.dpsMax = dpsMax;
    }
}
