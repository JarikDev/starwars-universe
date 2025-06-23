package cmd.starwars.universe.model.enums;

import lombok.Getter;

@Getter
public enum UnitClasses {
    CLONE("Clone trooper", Allegiances.REPUBLIC, 100.0f, 20.0f, 50.0f, 1.0f),
    CLONE_COMMANDO("Clone commando trooper", Allegiances.REPUBLIC, 150.0f, 30.0f, 75.0f, 1.5f),
    JEDI_MASTER("Jedi master", Allegiances.REPUBLIC, 100.0f, 30.0f, 75.0f, 3.0f),
    JEDI_KNIGHT("Jedi knight", Allegiances.REPUBLIC, 100.0f, 30.0f, 75.0f, 2.5f),
    JEDI_PADAWAN("Jedi padawan", Allegiances.REPUBLIC, 100.0f, 30.0f, 75.0f, 1.5f),
    DIPLOMAT("Diplomat", Allegiances.REPUBLIC, 100.0f, 30.0f, 75.0f, 2.5f),
    REBEL("Rebel", Allegiances.REPUBLIC, 100.0f, 20.0f, 75.0f, 1.5f),


    B_1("B 1 battle droid", Allegiances.SEPARATIST, 100.0f, 20.0f, 50.0f, 1.0f),
    B_2("B 2 battle droid", Allegiances.SEPARATIST, 150.0f, 30.0f, 75.0f, 1.0f),
    DROIDEKA("Droideka", Allegiances.SEPARATIST, 200.0f, 40.0f, 75.0f, 1.0f),
    SITH("Sith", Allegiances.SEPARATIST, 100.0f, 30.0f, 75.0f, 3.0f),
    PIRATE("Pirate", Allegiances.SEPARATIST, 100.0f, 30.0f, 75.0f, 1.5f),
    MANDALORIAN("Mandalorian", Allegiances.SEPARATIST, 200.0f, 50.0f, 75.0f, 1.5f),
    SEPARATIST_GENERAL("Separatist general", Allegiances.SEPARATIST, 100.0f, 20.0f, 75.0f, 5.0f),
    SEPARATIST_POLITICIAN("Separatist politician", Allegiances.SEPARATIST, 100.0f, 20.0f, 75.0f, 5.0f),
    INSURGENT("Insurgent", Allegiances.SEPARATIST, 100.0f, 20.0f, 75.0f, 2.0f),
    MERCENARY("Mercenary", Allegiances.SEPARATIST, 100.0f, 20.0f, 75.0f, 2.0f),
    ;
    private final String name;
    private final Allegiances allegiance;
    private final float hp;
    private final float dpsMin;
    private final float dpsMax;
    private final float buff;

    UnitClasses(String name, Allegiances allegiance, float hp, float dpsMin, float dpsMax, float buff) {
        this.name = name;
        this.allegiance = allegiance;
        this.hp = hp;
        this.dpsMin = dpsMin;
        this.dpsMax = dpsMax;
        this.buff = buff;
    }
}
