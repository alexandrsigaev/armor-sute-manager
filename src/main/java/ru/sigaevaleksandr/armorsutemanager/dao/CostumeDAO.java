package ru.sigaevaleksandr.armorsutemanager.dao;

import ru.sigaevaleksandr.armorsutemanager.model.Costume;

import java.util.List;

public interface CostumeDAO extends Repository<Costume, Integer> {
    List<Costume> findCostumesByParam(String param);
}
