package cmd.starwars.universe.model.messages;

import cmd.starwars.universe.model.enums.Allegiances;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ActionMessage {
    private Allegiances allegiance;
    private int unitId;
    private int targetId;
    private String unitClass;
    private String targetClass;
    private Actions action;

    public ActionMessage(Allegiances allegiance, Actions action) {
        this.allegiance = allegiance;
        this.action = action;
    }
}
