package cmd.starwars.universe.services.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class EntityServiceImpl<T> implements EntityService<T> {
    private final JpaRepository<T, Long> repo;

    public EntityServiceImpl(JpaRepository<T, Long> repo) {
        this.repo = repo;
    }

    @Override
    public void save(T entity) {
        repo.save(entity);
    }

    @Override
    public void delete(T entity) {
        repo.delete(entity);
    }

    @Override
    public T findById(long entityId) {
        return repo.findById(entityId).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return repo.findAll();
    }
}
