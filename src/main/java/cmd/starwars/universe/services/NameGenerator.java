package cmd.starwars.universe.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class NameGenerator {
    private static final String[] PREFIXES = {
            "V", "K", "Z", "T", "M", "X", "Y", "R", "L", "N",
            "D", "A", "E", "O", "U", "Q", "B", "F", "H", "G",
            "Ka", "Zo", "Xy", "Vor", "Th", "Zyr", "Korr", "Ryn", "Lur", "Nex"
    };
    private static final String[] SUFFIXES = {
            "ar", "on", "a", "is", "or", "en", "ex", "el", "an",
            "ion", "thar", "ron", "mir", "nix", "xor", "zar", "sion",
            "tion", "mir", "lar", "tar", "lor", "vor", "fen", "dex"
    };
    private static final String[] MIDDLE = {
            "Prime", "V", "X", "Zeta", "Tal", "Rho",
            "Sigma", "Kai", "Nar", "Zan", "Xen",
            "Lor", "Vex", "Delta", "Gamma", "Omega",
            "Alpha", "Beta", "Epsilon", "Theta", "Lambda"
    };

    private static final String[] SHIP_PREFIXES = {
            "V", "K", "Z", "T", "M", "X", "Y", "R", "L", "N",
            "D", "A", "E", "O", "U", "Q", "B", "F", "H", "G",
            "Star", "Imperial", "Rebel", "Shadow", "Aegis", "Eclipse",
            "Crimson", "Iron", "Storm", "Vanguard", "Solar"
    };

    private static final String[] SHIP_SUFFIXES = {
            "Destroyer", "Carrier", "Frigate", "Gunship", "Interceptor",
            "Cruiser", "Corvette", "Bomber", "Assault", "Commander",
            "ar", "on", "a", "is", "or", "en", "ex"
    };

    private static final String[] SHIP_MIDDLE = {
            "Class", "Fleet", "Array", "Squadron", "Legion",
            "V", "X", "Delta", "Omega", "Prime", "Alpha",
            "Beta", "Gamma", "Zeta", "Nexus", "Command"
    };

    public String generateTrooperName() {
        Random rand = new Random();
        String prefix = PREFIXES[rand.nextInt(PREFIXES.length)];
        String suffix = SUFFIXES[rand.nextInt(SUFFIXES.length)];
        String middle = MIDDLE[rand.nextInt(MIDDLE.length)];
        return prefix + suffix + " " + middle;
    }

    public ArrayList<String> generateNames(int count) {
        Random rand = new Random();
        ArrayList<String> names = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String prefix = PREFIXES[rand.nextInt(PREFIXES.length)];
            String suffix = SUFFIXES[rand.nextInt(SUFFIXES.length)];
            String middle = MIDDLE[rand.nextInt(MIDDLE.length)];
            int number = rand.nextInt(100); // Optional: add numbers
            names.add(prefix + suffix + middle + (number > 0 ? "-" + number : ""));
        }

        return names;
    }

    public String generateShipName() {
        Random rand = new Random();
        String prefix = SHIP_PREFIXES[rand.nextInt(SHIP_PREFIXES.length)];
        String suffix = SHIP_SUFFIXES[rand.nextInt(SHIP_SUFFIXES.length)];
        String middle = SHIP_MIDDLE[rand.nextInt(SHIP_MIDDLE.length)];

        return prefix + suffix + " " + middle;
    }

}
