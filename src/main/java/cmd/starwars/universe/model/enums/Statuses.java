package cmd.starwars.universe.model.enums;

import lombok.Getter;

@Getter
public enum Statuses {
    ACTIVE("Active"),
    DESTROYED("Destroyed");
    private final String name;

    Statuses(String name) {
        this.name = name;
    }
}
