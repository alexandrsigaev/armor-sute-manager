package ru.sigaevaleksandr.armorsutemanager.service;

import ru.sigaevaleksandr.armorsutemanager.exeption.NotFoundException;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;

import java.util.List;
import java.util.Optional;

public interface CostumeService {

    List<Costume> findAll();
    Optional<Costume> getCostume(int id) throws NotFoundException;
    Costume save(Costume costume);
    void delete(Costume costume);
    List<Costume> getCostumesByArtifact(String param);
    List<Costume> getCostumesByType(String type);
}
