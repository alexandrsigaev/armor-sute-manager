package ru.sigaevaleksandr.armorsutemanager.dao;

import java.util.List;
import java.util.Optional;

public interface Repository<T, Id> {
    int persist(T entity);

    int update(T entity);

    Optional<T> findById(Id id);

    int delete(T entity);

    List<T> findAll();
}
