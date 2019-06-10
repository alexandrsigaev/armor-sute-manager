package ru.sigaevaleksandr.armorsutemanager.service;

import ru.sigaevaleksandr.armorsutemanager.exeption.NotFoundException;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;

import java.util.List;
import java.util.Optional;

public interface CostumeService {

    List<Costume> findAll();
    Optional<Costume> findById(int id);
    Costume save(Costume costume);
    void delete(Costume costume);
    List<Costume> findByArtifact(String param);
    double armorLoad(int id) throws NotFoundException;
}
