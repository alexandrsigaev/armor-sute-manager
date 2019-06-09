package ru.sigaevaleksandr.armorsutemanager.service.impl;

import org.springframework.stereotype.Service;
import ru.sigaevaleksandr.armorsutemanager.dao.CostumeDAO;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;
import ru.sigaevaleksandr.armorsutemanager.service.CostumeService;

import java.util.List;
import java.util.Optional;

@Service
public class CostumeServiceImpl implements CostumeService {

    private final CostumeDAO costumeDAO;

    public CostumeServiceImpl(CostumeDAO costumeDAO) {
        this.costumeDAO = costumeDAO;
    }

    @Override
    public boolean addCostume(Costume person) {
        return false;
    }

    @Override
    public boolean updateCostume(Costume costume) {
        return false;
    }

    @Override
    public List<Costume> getAllCostume() {
        return null;
    }

    @Override
    public Optional<Costume> getCostumeByName() {
        return Optional.empty();
    }
}
