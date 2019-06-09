package ru.sigaevaleksandr.armorsutemanager.dao.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sigaevaleksandr.armorsutemanager.dao.ArmorDAO;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArmorDAOImplTest {

    @Autowired
    ArmorDAO armorDAO;

    @Ignore
    @Test
    public void whenPersistArmor() {
        Armor armor = new Armor();
        armor.setIdCostume(2);
        armor.setNameArmor("qwerty");
        armor.setArtifact("qwerty");
        Integer id = this.armorDAO.persist(armor);
        Optional<Armor> cond = this.armorDAO.findById(id);
        assertTrue(cond.isPresent());
        assertThat(armor, is(cond.get()));
    }

    @Test
    public void update() {

    }

    @Test
    public void findById() {

    }

    @Test
    public void delete() {

    }

    @Test
    public void findAll() {

    }
}