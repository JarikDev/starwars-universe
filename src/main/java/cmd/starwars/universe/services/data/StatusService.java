package cmd.starwars.universe.services.data;

import cmd.starwars.universe.repo.StatusRepository;
import cmd.starwars.universe.repo.entities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository statuses;

    @Autowired
    public StatusService(StatusRepository statuses) {
        this.statuses = statuses;
    }

    public void save(Status status) {
        statuses.save(status);
    }

    public void delete(Status status) {
        statuses.delete(status);
    }

    public Status findById(long statusId) {
        return statuses.findById(statusId)
                .orElse(null);
    }

    public Status findByName(String name) {
        return statuses.findStatusByName(name)
                .orElse(null);
    }

    public List<Status> findAll() {
        return statuses.findAll();
    }
}
