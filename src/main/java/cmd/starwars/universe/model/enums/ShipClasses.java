package cmd.starwars.universe.model.enums;

import lombok.Getter;

@Getter
public enum ShipClasses {
    VENATOR("Venator Star Destroyer", Allegiances.REPUBLIC, 1000000.0f, 1000.0f, 5000.0f),
    ACCLAMATOR("Acclamator Assault Ship", Allegiances.REPUBLIC, 500000.0f, 1000.0f, 5000.0f),
    VICTORY("Victory Star Destroyer", Allegiances.REPUBLIC, 50000.0f, 1000.0f, 5000.0f),
    ARQUITENS("Arquitens Light Cruiser", Allegiances.REPUBLIC, 20000.0f, 1000.0f, 5000.0f),
    CONSULAR("Consular Cruiser", Allegiances.REPUBLIC, 10000.0f, 500.0f, 700.0f),
    DREADNAUGHT("Dreadnaught Heavy Cruiser", Allegiances.REPUBLIC, 1000.0f, 10.0f, 20.0f),
    ARC_170("ARC-170 Heavy fighter", Allegiances.REPUBLIC, 2000.0f, 1000.0f, 1500.0f),
    V_19("V-19 fighter", Allegiances.REPUBLIC, 1000.0f, 500.0f, 1000.0f),
    Z_95("Z-95 fighter", Allegiances.REPUBLIC, 1000.0f, 500.0f, 1000.0f),
    LAAT("LAAT Gunship", Allegiances.REPUBLIC, 2000.0f, 1000.0f, 1500.0f),
    DELTA_7("Delta-7 fighter", Allegiances.REPUBLIC, 1000.0f, 500.0f, 1000.0f),

    PROVIDENCE("Providence Dreadnought", Allegiances.SEPARATIST, 1000000.0f, 1000.0f, 5000.0f),
    LUCREHULK("Lucrehulk Battleship", Allegiances.SEPARATIST, 500000.0f, 5000.0f, 15000.0f),
    MUNIFICENT("Munificent Frigate", Allegiances.SEPARATIST, 50000.0f, 1000.0f, 5000.0f),
    RECUSANT("Recusant Star Destroyer", Allegiances.SEPARATIST, 50000.0f, 1000.0f, 5000.0f),
    DH_OMNI("DH-Omni Support Vessel", Allegiances.SEPARATIST, 10000.0f, 500.0f, 700.0f),
    HARDCELL("Hardcell Transport", Allegiances.SEPARATIST, 10000.0f, 500.0f, 700.0f),
    VULTURE_DROID("Vulture Droid fighter", Allegiances.SEPARATIST, 1000.0f, 500.0f, 1000.0f),
    HYENA("Hyena bomber", Allegiances.SEPARATIST, 1000.0f, 2000.0f, 5000.0f),
    TRI("Tri fighter", Allegiances.SEPARATIST, 1000.0f, 500.0f, 1000.0f),
    HMP("HMP Gunship", Allegiances.SEPARATIST, 2000.0f, 1000.0f, 1500.0f),
    BELBULLAB_22("Belbullab-22 fighter", Allegiances.SEPARATIST, 1000.0f, 500.0f, 1000.0f),
    ;
    private final String name;
    private final Allegiances allegiance;
    private final float hp;
    private final float dpsMin;
    private final float dpsMax;

    ShipClasses(String name, Allegiances allegiance, float hp, float dpsMin, float dpsMax) {
        this.name = name;
        this.allegiance = allegiance;
        this.hp = hp;
        this.dpsMin = dpsMin;
        this.dpsMax = dpsMax;
    }
}

/**
 * Galactic Republic Ships
 * (Venator-class is the iconic symbol of the Republic Navy)
 * Capital Ships
 * 1. Venator-class Star Destroyer
 * Primary Republic cruiser (carrier/destroyer hybrid)
 * Carries 192 V-19 Torrents/ARC-170s + 40 LAAT gunships Example: Resolute (Admiral Yularen's flagship)
 * 2. Acclamator-class Assault Ship
 * Troop transport (16,000 clones + 80 LAATs)
 * Used in early-war invasions (e.g., Geonosis)
 * 3. Victory-class Star Destroyer (Late-War)
 * • Heavier than Venators; phased in near war's end Foreshadowed Imperial designs
 * Frigates & Support
 * 4. Arquitens-class Light Cruiser
 * Escort/patrol vessel (dual turbo lasers)
 * 5. Consular-class Cruiser
 * Diplomatic ship (often armed for wa
 * <p>
 * <p>
 * 6. Dreadnaught-class Heavy Cruiser
 * Older model; used by Republic loyalist militias
 * Starfighters
 * 7. ARC-170
 * Heavy fighter (3 crew, hyperdrive)
 * 8. V-19 Torrent
 * Early-war fighter (phased out for Z-95s)
 * 9. Z-95 Headhunter
 * Cheap, modular fighter (used by clones/privateers)
 * 10. LAAT/i Gunship
 * Iconic troop transport ("Republic Attack Gunship")
 * 11. Delta-7 Aethersprite (Jedi Starfighter)
 * Used by Jedi (Obi-Wan's Delta-7B)
 * <p>
 * SEPARATISTS
 * <p>
 * <p>
 * Separatist Alliance Ships
 * (Droid-controlled fleets with overwhelming numbers)
 * Capital Ships
 * 1. Providence-class Dreadnought
 * Flagship of the CIS Navy (used by Grievous/Dooku)
 * Example: Invisible Hand (Grievous' flagship)
 * 2. Lucrehulk-class Battleship
 * Converted Trade Federation cargo ship (1,500 droid fighters)
 * Core of early-war fleets
 * 3. Munificent-class Star Frigate
 * Long-range communications/artillery ship
 * 4. Recusant-class Light Destroyer
 * ⚫ Cheap, disposable warship (droid-controlled)
 * Frigates & Support
 * 5. DH-Omni Support Vessel
 * Modular supply ship/improvised carrier
 * 6. Hardcell-class Transport
 * Techno Union troop carrier
 * <p>
 * <p>
 * Starfighters & Dropships
 * 7. Vulture Droid
 * Swarm fighter (can walk as ground unit)
 * 8. Hyena-class Bomber
 * Droid bomber (anti-capital ship)
 * 9. Tri-fighter
 * Advanced droid interceptor (outmatched ARC-170s)
 * 10. HMP Droid Gunship
 * Air/ground assault craft ("Droid Gunship")
 * 11. Belbullab-22
 * Grievous' personal starfighter (Soulless One)
 */