package carsharing.service;

import java.util.List;

public interface CarSharingDao<T> {

    T findById(int id);
    List<T> findAll();
    void save(String name);
}
