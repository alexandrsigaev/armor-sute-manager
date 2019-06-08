package ru.sigaevaleksandr.armorsutemanager.service.impl;

import org.springframework.stereotype.Service;
import ru.sigaevaleksandr.armorsutemanager.dao.ArmorDAO;
import ru.sigaevaleksandr.armorsutemanager.service.ArmorService;

@Service
public class ArmorServiceImpl implements ArmorService {

    private final ArmorDAO armorDAO;

    public ArmorServiceImpl(ArmorDAO armorDAO) {
        this.armorDAO = armorDAO;
    }
}
