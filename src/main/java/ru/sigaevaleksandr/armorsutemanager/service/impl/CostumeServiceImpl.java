package ru.sigaevaleksandr.armorsutemanager.service.impl;

import org.springframework.stereotype.Service;
import ru.sigaevaleksandr.armorsutemanager.dao.CostumeDAO;
import ru.sigaevaleksandr.armorsutemanager.service.CostumeService;

@Service
public class CostumeServiceImpl implements CostumeService {

    private final CostumeDAO costumeDAO;

    public CostumeServiceImpl(CostumeDAO costumeDAO) {
        this.costumeDAO = costumeDAO;
    }

}
