package cmd.starwars.universe.model.units;

import java.util.Random;

public interface Attackable {
    float getDamage();
    default float getDamage(float from, float to) {
        Random random = new Random();
        return random.nextFloat(from, to);
    }
}
