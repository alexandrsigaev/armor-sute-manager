package ru.sigaevaleksandr.armorsutemanager.service;

import ru.sigaevaleksandr.armorsutemanager.model.Costume;

import java.util.List;
import java.util.Optional;

public interface CostumeService {

    boolean addCostume(Costume person);
    boolean updateCostume(Costume costume);
    List<Costume> getAllCostume();
    Optional<Costume> getCostumeByName();

}
