package ru.sigaevaleksandr.armorsutemanager.dao;

import ru.sigaevaleksandr.armorsutemanager.model.UnitStore;

import java.util.Optional;

public interface UnitStoreDAO extends Repository<UnitStore, Integer> {
    int updateLeftAmountByArmorId(UnitStore store);
    Optional<UnitStore> findByArmorId(int armorId);
}
