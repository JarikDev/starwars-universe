package cmd.starwars.universe.services;

import java.util.List;

public interface RandomElement<T> {
    T get(List<T> list);
}
