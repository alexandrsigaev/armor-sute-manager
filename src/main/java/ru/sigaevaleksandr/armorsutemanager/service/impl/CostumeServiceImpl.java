package ru.sigaevaleksandr.armorsutemanager.service.impl;

import org.springframework.stereotype.Service;
import ru.sigaevaleksandr.armorsutemanager.dao.CostumeDAO;
import ru.sigaevaleksandr.armorsutemanager.exeption.NotFoundException;
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
    public List<Costume> findAll() {
        return this.costumeDAO.findAll();
    }

    @Override
    public Optional<Costume> findById(int id) {
        return this.costumeDAO.findById(id);
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
    public List<Costume> findByArtifact(String param) {
        return this.costumeDAO.findCostumesByParam(param);
    }

    @Override
    public double armorLoad(int id) throws NotFoundException {
        Optional<Costume> costume = this.findById(id);
        if (!costume.isPresent()) {
            throw new NotFoundException(String.format("Costume with id %s if not found", id));
        }
        return costume.get().getLoadArmor();
    }
}
