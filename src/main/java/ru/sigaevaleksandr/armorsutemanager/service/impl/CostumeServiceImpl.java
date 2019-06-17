package ru.sigaevaleksandr.armorsutemanager.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sigaevaleksandr.armorsutemanager.dao.CostumeDAO;
import ru.sigaevaleksandr.armorsutemanager.dao.UnitStoreDAO;
import ru.sigaevaleksandr.armorsutemanager.exeption.NotFoundException;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;
import ru.sigaevaleksandr.armorsutemanager.model.CostumeType;
import ru.sigaevaleksandr.armorsutemanager.model.UnitStore;
import ru.sigaevaleksandr.armorsutemanager.service.CostumeService;

import java.util.List;
import java.util.Optional;

@Service
public class CostumeServiceImpl implements CostumeService {

    private final CostumeDAO costumeDAO;
    private final UnitStoreDAO unitStoreDAO;

    public CostumeServiceImpl(CostumeDAO costumeDAO, UnitStoreDAO unitStoreDAO) {
        this.costumeDAO = costumeDAO;
        this.unitStoreDAO = unitStoreDAO;
    }

    @Override
    public List<Costume> findAll() {
        return this.costumeDAO.findAll();
    }

    @Override
    @Transactional
    public Optional<Costume> getCostume(int id) throws NotFoundException {
        Optional<Costume> res = this.costumeDAO.findById(id);
        if (!res.isPresent()) {
            throw new NotFoundException(String.format("Costume with id %s if not found", id));
        }
        this.complete(res.get());
        return res;
    }

    @Override
    public Costume save(Costume costume) {
        int id = this.costumeDAO.persist(costume);
        costume.setId(id);
        return costume;
    }

    @Override
    public void delete(Costume costume) {
        this.costumeDAO.delete(costume);
    }

    @Override
    public List<Costume> getCostumesByArtifact(String param) {
        return this.costumeDAO.findCostumesByParam(param);
    }

    @Override
    public List<Costume> getCostumesByType(String type) {
        CostumeType costumeType = CostumeType.valueOf(type.toUpperCase());
        return this.costumeDAO.findCostumesByType(costumeType);
    }

    private void complete(Costume costume) {
        List<Armor> armors = costume.getArmors();
        for (Armor arm : armors) {
            Optional<UnitStore> storeCandidate = this.unitStoreDAO.findByArmorId(arm.getId());
            if (storeCandidate.isPresent()) {
                UnitStore store = storeCandidate.get();
                int amountLeft = store.getAmountLeftInStorage();
                if (amountLeft <= arm.getUnitMax()) {
                    arm.setUnitLeft(amountLeft);
                    store.setAmountLeftInStorage(0);
                } else {
                    amountLeft -= arm.getUnitMax();
                    arm.setUnitLeft(arm.getUnitMax());
                    store.setAmountLeftInStorage(amountLeft);
                }
                this.unitStoreDAO.update(store);
            }
        }
    }
}
