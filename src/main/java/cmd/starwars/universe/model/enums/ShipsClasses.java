package cmd.starwars.universe.model.enums;

public enum ShipsClasses {

    ;
    private final String name;
    private final Allegiances allegiance;
    private final float hp;
    private final float dpsMin;

    ShipsClasses(String name, Allegiances allegiance, float hp, float dpsMin, float dpsMax) {
        this.name = name;
        this.allegiance = allegiance;
        this.hp = hp;
        this.dpsMin = dpsMin;
        this.dpsMax = dpsMax;
    }

    private final float dpsMax;
}

/**
 *
 Galactic Republic Ships
 (Venator-class is the iconic symbol of the Republic Navy)
 Capital Ships
 1. Venator-class Star Destroyer
 Primary Republic cruiser (carrier/destroyer hybrid)
 Carries 192 V-19 Torrents/ARC-170s + 40 LAAT gunships Example: Resolute (Admiral Yularen's flagship)
 2. Acclamator-class Assault Ship
 Troop transport (16,000 clones + 80 LAATs)
 Used in early-war invasions (e.g., Geonosis)
 3. Victory-class Star Destroyer (Late-War)
 • Heavier than Venators; phased in near war's end Foreshadowed Imperial designs
 Frigates & Support
 4. Arquitens-class Light Cruiser
 Escort/patrol vessel (dual turbo lasers)
 5. Consular-class Cruiser
 Diplomatic ship (often armed for wa


 6. Dreadnaught-class Heavy Cruiser
 Older model; used by Republic loyalist militias
 Starfighters
 7. ARC-170
 Heavy fighter (3 crew, hyperdrive)
 8. V-19 Torrent
 Early-war fighter (phased out for Z-95s)
 9. Z-95 Headhunter
 Cheap, modular fighter (used by clones/privateers)
 10. LAAT/i Gunship
 Iconic troop transport ("Republic Attack Gunship")
 11. Delta-7 Aethersprite (Jedi Starfighter)
 Used by Jedi (Obi-Wan's Delta-7B)

 SEPARATISTS


 Separatist Alliance Ships
 (Droid-controlled fleets with overwhelming numbers)
 Capital Ships
 1. Providence-class Dreadnought
 Flagship of the CIS Navy (used by Grievous/Dooku)
 Example: Invisible Hand (Grievous' flagship)
 2. Lucrehulk-class Battleship
 Converted Trade Federation cargo ship (1,500 droid fighters)
 Core of early-war fleets
 3. Munificent-class Star Frigate
 Long-range communications/artillery ship
 4. Recusant-class Light Destroyer
 ⚫ Cheap, disposable warship (droid-controlled)
 Frigates & Support
 5. DH-Omni Support Vessel
 Modular supply ship/improvised carrier
 6. Hardcell-class Transport
 Techno Union troop carrier


 Starfighters & Dropships
 7. Vulture Droid
 Swarm fighter (can walk as ground unit)
 8. Hyena-class Bomber
 Droid bomber (anti-capital ship)
 9. Tri-fighter
 Advanced droid interceptor (outmatched ARC-170s)
 10. HMP Droid Gunship
 Air/ground assault craft ("Droid Gunship")
 11. Belbullab-22
 Grievous' personal starfighter (Soulless One)
 */