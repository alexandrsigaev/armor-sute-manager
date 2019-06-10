package ru.sigaevaleksandr.armorsutemanager.service;

import ru.sigaevaleksandr.armorsutemanager.exeption.ServiceException;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;

import java.util.List;
import java.util.Optional;

public interface ArmorService {

    List<Armor> findAll();
    Optional<Armor> findById(int id);
    Armor save(Armor armor) throws ServiceException;
    void delete(Armor armor);
    void update(Armor armor);

}
