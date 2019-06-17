package ru.sigaevaleksandr.armorsutemanager.dao;

import ru.sigaevaleksandr.armorsutemanager.model.Costume;
import ru.sigaevaleksandr.armorsutemanager.model.CostumeType;

import java.util.List;

public interface CostumeDAO extends Repository<Costume, Integer> {
    List<Costume> findCostumesByParam(String param);
    List<Costume> findCostumesByType(CostumeType type);
}
