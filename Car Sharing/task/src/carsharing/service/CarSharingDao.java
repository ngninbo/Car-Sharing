package carsharing.service;

import java.util.List;
import java.util.Optional;

public interface CarSharingDao<T> {

    Optional<T> findById(int id);
    List<T> findAll();
    void save(String name);
}
