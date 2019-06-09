package ru.sigaevaleksandr.armorsutemanager.dao.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sigaevaleksandr.armorsutemanager.dao.CostumeDAO;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CostumeDAOImplTest {

    @Autowired
    private CostumeDAO costumeDAO;

    @Test
    public void persist() {

    }

    @Test
    public void update() {
    }

    @Ignore
    @Test
    public void whenFindById() {
        Optional<Costume> byId = costumeDAO.findById(2);
        byId.ifPresent(System.out::println);
    }

    @Test
    public void delete() {
    }

    @Test
    public void findAll() {
    }
}