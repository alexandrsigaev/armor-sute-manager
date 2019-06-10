package ru.sigaevaleksandr.armorsutemanager.service.impl;

import org.springframework.stereotype.Service;
import ru.sigaevaleksandr.armorsutemanager.dao.ArmorDAO;
import ru.sigaevaleksandr.armorsutemanager.dao.CostumeDAO;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;
import ru.sigaevaleksandr.armorsutemanager.service.ArmorService;
import ru.sigaevaleksandr.armorsutemanager.exeption.ServiceException;

import java.util.List;
import java.util.Optional;

@Service
public class ArmorServiceImpl implements ArmorService {

    private final ArmorDAO armorDAO;
    private final CostumeDAO costumeDAO;

    public ArmorServiceImpl(ArmorDAO armorDAO, CostumeDAO costumeDAO) {
        this.armorDAO = armorDAO;
        this.costumeDAO = costumeDAO;
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
    public Armor save(Armor armor) throws ServiceException {
        Optional<Costume> opCostume = this.costumeDAO.findById(armor.getIdCostume());
        if (!opCostume.isPresent() || (opCostume.get().getMaxCountArmor() <= opCostume.get().getArmors().size())) {
            throw new ServiceException(String.format("Costume with id %s not found or complete", armor.getIdCostume()));
        }
        int id = this.armorDAO.persist(armor);
        armor.setId(id);
        return armor;
    }

    @Override
    public void delete(Armor armor) {
        this.armorDAO.delete(armor);
    }

    @Override
    public void update(Armor armor) {
        this.armorDAO.update(armor);
    }
}