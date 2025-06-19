package cmd.starwars.universe.model.messages;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ActionMessage {
    private int unitId;
    private int targetId;
    private String unitClass;
    private String targetClass;
    private Actions action;
}
