package cmd.starwars.universe.services.data;

import java.util.List;

public interface EntityService<T> {

    void save(T entity);

    void delete(T entity);

    T findById(long entityId);

    List<T> findAll();
}
