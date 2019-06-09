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
    public List<Costume> findAll() {
        return costumeDAO.findAll();
    }

    @Override
    public Optional<Costume> findById(int id) {
        return costumeDAO.findById(id);
    }

    @Override
    public Costume save(Costume costume) {
        int id = costumeDAO.persist(costume);
        costume.setId(id);
        return costume;
    }

    @Override
    public void delete(Costume costume) {
        costumeDAO.delete(costume);
    }
}
