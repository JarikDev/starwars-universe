package cmd.starwars.universe.services.kafka.handlers;

import cmd.starwars.universe.model.enums.Statuses;
import cmd.starwars.universe.model.messages.ActionMessage;
import cmd.starwars.universe.model.messages.Actions;
import cmd.starwars.universe.repo.entities.*;
import cmd.starwars.universe.services.data.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ActionMessageHandler {
    private final AllegianceService allegiances;
    private final StatusService statuses;
    private final ShipClassService shipClasses;
    private final UnitClassService unitClasses;
    private final HeroService heroes;
    private final PlanetService planets;
    private final ShipService ships;
    private final StarSystemService starSystems;
    private final UnitService units;

    @Autowired
    public ActionMessageHandler(AllegianceService allegiances,
                                StatusService statuses,
                                ShipClassService shipClasses,
                                UnitClassService unitClasses,
                                HeroService heroes,
                                PlanetService planets,
                                ShipService ships,
                                StarSystemService starSystems,
                                UnitService units) {
        this.allegiances = allegiances;
        this.statuses = statuses;
        this.shipClasses = shipClasses;
        this.unitClasses = unitClasses;
        this.heroes = heroes;
        this.planets = planets;
        this.ships = ships;
        this.starSystems = starSystems;
        this.units = units;
    }

    public void handle(ActionMessage msg) {
        switch (msg.getUnitClass()) {
            case "HERO":
                handleHeroAction(msg);
                break;
            case "SHIP":
                handleShipAction(msg);
                break;
            case "UNIT":
                handleUnitAction(msg);
                break;
            default:
                throw new RuntimeException("Unknown class: " + msg.getUnitClass());
        }
    }

    private void handleHeroAction(ActionMessage msg) {
        log.info("handled HeroAction");
        switch (msg.getAction()) {
            case Actions.ATTACK:
                handleHeroAttack(msg);
            case Actions.MOVE:
                handleHeroMove(msg);
            default:
                throw new RuntimeException("Unknown action: " + msg.getAction());
        }
    }

    private void handleHeroAttack(ActionMessage msg) {
        Hero attacker = heroes.findById(msg.getUnitId());
        float dmg = attacker.getDamage();
        if ("HERO".equals(msg.getTargetClass())) {
            Hero target = heroes.findById(msg.getTargetId());
            target.setHp(target.getHp() - dmg);
            if (target.getHp() < 0) {
                Status destroyed = statuses.findByName(Statuses.DESTROYED.name());
                target.setStatus(destroyed);
            }
            heroes.save(target);
        } else {
            Unit target = units.findById(msg.getTargetId());
            target.setHp(target.getHp() - dmg);
            if (target.getHp() < 0) {
                Status destroyed = statuses.findByName(Statuses.DESTROYED.name());
                target.setStatus(destroyed);
            }
            units.save(target);
        }
        attacker.setTotalDamage(attacker.getTotalDamage() + dmg);
        heroes.save(attacker);
    }

    private void handleHeroMove(ActionMessage msg) {
        Hero hero = heroes.findById(msg.getUnitId());
        Planet planet = planets.findById(msg.getTargetId());
        hero.setPlanet(planet);
        heroes.save(hero);
    }

    private void handleShipAction(ActionMessage msg) {
        log.info("handled ShipAction");
        switch (msg.getAction()) {
            case Actions.ATTACK:
                handleShipAttack(msg);
            case Actions.MOVE:
                handleShipMove(msg);
            default:
                throw new RuntimeException("Unknown action: " + msg.getAction());
        }
    }

    private void handleShipAttack(ActionMessage msg) {
        Ship attacker = ships.findById(msg.getUnitId());
        Ship target = ships.findById(msg.getTargetId());
        float dmg = attacker.getDamage();
        target.setHp(target.getHp() - dmg);
        if (target.getHp() < 0) {
            Status destroyed = statuses.findByName(Statuses.DESTROYED.name());
            target.setStatus(destroyed);
        }
        ships.save(target);
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
        if ("HERO".equals(msg.getTargetClass())) {
            Hero target = heroes.findById(msg.getTargetId());
            target.setHp(target.getHp() - dmg);
            if (target.getHp() < 0) {
                Status destroyed = statuses.findByName(Statuses.DESTROYED.name());
                target.setStatus(destroyed);
            }
            heroes.save(target);
        } else {
            Unit target = units.findById(msg.getTargetId());
            target.setHp(target.getHp() - dmg);
            if (target.getHp() < 0) {
                Status destroyed = statuses.findByName(Statuses.DESTROYED.name());
                target.setStatus(destroyed);
            }
            units.save(target);
        }
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
