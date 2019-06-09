package ru.sigaevaleksandr.armorsutemanager.service;

import ru.sigaevaleksandr.armorsutemanager.model.Armor;

import java.util.List;
import java.util.Optional;

public interface ArmorService {

    List<Armor> findAll();
    Optional<Armor> findById(int id);
    Armor save(Armor armor);
    void delete(Armor armor);
}
