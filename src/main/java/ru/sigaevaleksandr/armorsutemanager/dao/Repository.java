package ru.sigaevaleksandr.armorsutemanager.dao;

import java.io.Serializable;
import java.util.List;

public interface Repository<T, Id> {
    void persist(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(T entity);

    List<T> findAll();
}
