package cmd.starwars.universe.model.enums;

import lombok.Getter;

@Getter
public enum Allegiances {
    SEPARATIST("Separatist"),
    REPUBLIC("Republic"),
    JEDI("Jedi"),
    CLONE_TROOPER("Clone trooper"),
    HUTT("Hutt"),
    EMPIRE("Empire"),
    PIRATE("Pirate"),
    MERCENARY("Mercenary"),
    BOUNTY_HUNTER("Bounty hunter");


    private final String name;

    Allegiances(String name) {
        this.name = name;
    }
}
