package cmd.starwars.universe.services.impl;

import cmd.starwars.universe.services.RandomElement;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RandomElementImpl<T> implements RandomElement<T> {
    @Override
    public T get(List<T> list) {
        Random random = new Random();
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}
