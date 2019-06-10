package ru.sigaevaleksandr.armorsutemanager.service.impl;

import org.springframework.stereotype.Service;
import ru.sigaevaleksandr.armorsutemanager.dao.ArmorDAO;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;
import ru.sigaevaleksandr.armorsutemanager.service.ArmorService;

import java.util.List;
import java.util.Optional;

@Service
public class ArmorServiceImpl implements ArmorService {

    private final ArmorDAO armorDAO;

    public ArmorServiceImpl(ArmorDAO armorDAO) {
        this.armorDAO = armorDAO;
    }

    @Override
    public List<Armor> findAll() {
        return this.armorDAO.findAll();
    }

    @Override
    public Optional<Armor> findById(int id) {
        return this.armorDAO.findById(id);
    }

    @Override
    public Armor save(Armor armor) {
        int id = this.armorDAO.persist(armor);
        armor.setId(id);
        return armor;
    }

    @Override
    public void delete(Armor armor) {
        this.armorDAO.delete(armor);
    }
}