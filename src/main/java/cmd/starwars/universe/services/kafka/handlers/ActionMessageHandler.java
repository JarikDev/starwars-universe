package cmd.starwars.universe.services.kafka.handlers;

import cmd.starwars.universe.model.enums.Allegiances;
import cmd.starwars.universe.model.enums.ShipClasses;
import cmd.starwars.universe.model.enums.Statuses;
import cmd.starwars.universe.model.enums.UnitClasses;
import cmd.starwars.universe.model.messages.ActionMessage;
import cmd.starwars.universe.model.messages.Actions;
import cmd.starwars.universe.repo.entities.*;
import cmd.starwars.universe.services.data.*;
import cmd.starwars.universe.services.kafka.KafkaSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ActionMessageHandler {
    private final AllegianceService allegiances;
    private final StatusService statuses;
    private final ShipClassService shipClasses;
    private final UnitClassService unitClasses;
    private final PlanetService planets;
    private final ShipService ships;
    private final StarSystemService starSystems;
    private final UnitService units;
    private final KafkaSender sender;
    private final List<String> unitClassesList;
    private final List<String> shipClassesList;

    @Autowired
    public ActionMessageHandler(AllegianceService allegiances,
                                StatusService statuses,
                                ShipClassService shipClasses,
                                UnitClassService unitClasses,
                                PlanetService planets,
                                ShipService ships,
                                StarSystemService starSystems,
                                UnitService units, KafkaSender sender) {
        this.allegiances = allegiances;
        this.statuses = statuses;
        this.shipClasses = shipClasses;
        this.unitClasses = unitClasses;
        this.planets = planets;
        this.ships = ships;
        this.starSystems = starSystems;
        this.units = units;
        this.sender = sender;

        unitClassesList = Arrays.stream(UnitClasses.values()).map(UnitClasses::name).collect(Collectors.toList());
        shipClassesList = Arrays.stream(ShipClasses.values()).map(ShipClasses::name).collect(Collectors.toList());
    }

    public void handle(ActionMessage msg) {
        if (msg.getAction().equals(Actions.FINISHED)) {
//            Allegiances allegiance = msg.getAllegiance().equals(Allegiances.REPUBLIC) ? Allegiances.SEPARATIST : Allegiances.REPUBLIC;
            Allegiances allegiance = Allegiances.REPUBLIC;
            ActionMessage turn_msg = new ActionMessage(allegiance, Actions.START);
            sender.sendMessage(turn_msg, "action_topic");
        } else if (msg.getAction().equals(Actions.START)) {
            log.info("SOME SIDE HAS STARTED");
        } else if (msg.getAction().equals(Actions.WON)) {
            log.info("SOME SIDE HAS WON");
        } else {
            if (shipClassesList.contains(msg.getUnitClass())) {
                handleShipAction(msg);
            } else if (unitClassesList.contains(msg.getUnitClass())) {
                handleUnitAction(msg);
            } else {
                throw new RuntimeException("Unknown class: " + msg.getUnitClass());
            }
        }
    }

    private void handleShipAction(ActionMessage msg) {
        log.info("handled ShipAction");
        switch (msg.getAction()) {
            case Actions.ATTACK:
                handleShipAttack(msg);
                break;
            case Actions.MOVE:
                handleShipMove(msg);
                break;
            default:
                throw new RuntimeException("Unknown action: " + msg.getAction());
        }
    }

    private void handleShipAttack(ActionMessage msg) {
        Ship attacker = ships.findById(msg.getUnitId());
        float dmg = attacker.getDamage();
        Ship target = ships.findById(msg.getTargetId());
        if (target == null) {
            Unit targetUnit = units.findById(msg.getTargetId());
            targetUnit.setHp(targetUnit.getHp() - dmg);
            if (targetUnit.getHp() < 0) {
                Status destroyed = statuses.findByName(Statuses.DESTROYED.name());
                targetUnit.setStatus(destroyed);
            }
            units.save(targetUnit);
        } else {
            target.setHp(target.getHp() - dmg);
            if (target.getHp() < 0) {
                Status destroyed = statuses.findByName(Statuses.DESTROYED.name());
                target.setStatus(destroyed);
            }
            ships.save(target);
        }
        attacker.setTotalDamage(attacker.getTotalDamage() + dmg);
        ships.save(attacker);
    }

    private void handleShipMove(ActionMessage msg) {
        Ship ship = ships.findById(msg.getUnitId());
        StarSystem system = starSystems.findById(msg.getTargetId());
        ship.setStarSystem(system);
        ships.save(ship);
    }

    private void handleUnitAction(ActionMessage msg) {
        log.info("handled UnitAction");
        switch (msg.getAction()) {
            case Actions.ATTACK:
                handleUnitAttack(msg);
                break;
            case Actions.MOVE:
                handleUnitMove(msg);
                break;
            default:
                throw new RuntimeException("Unknown action: " + msg.getAction());
        }
    }

    private void handleUnitAttack(ActionMessage msg) {
        Unit attacker = units.findById(msg.getUnitId());
        float dmg = attacker.getDamage();
        Unit target = units.findById(msg.getTargetId());
        target.setHp(target.getHp() - dmg);
        if (target.getHp() < 0) {
            Status destroyed = statuses.findByName(Statuses.DESTROYED.name());
            target.setStatus(destroyed);
        }
        units.save(target);
        attacker.setTotalDamage(attacker.getTotalDamage() + dmg);
        units.save(attacker);
    }

    private void handleUnitMove(ActionMessage msg) {
        Unit unit = units.findById(msg.getUnitId());
        Planet planet = planets.findById(msg.getTargetId());
        unit.setPlanet(planet);
        units.save(unit);
    }
}
