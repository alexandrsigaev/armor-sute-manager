package ru.sigaevaleksandr.armorsutemanager.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sigaevaleksandr.armorsutemanager.dao.ArmorDAO;
import ru.sigaevaleksandr.armorsutemanager.dao.CostumeDAO;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArmorDAOImplTest {

    Costume costume;

    @Autowired
    ArmorDAO armorDAO;
    @Autowired
    CostumeDAO costumeDAO;

    @Before
    public void setUp() throws Exception {
        costume = costumeDAO.findAll().stream().findAny().get();
    }

    @Test
    public void whenPersistArmor() {
        Armor armor = new Armor(null, "gun", "power",
                1, 0, this.costume.getId());
        Integer id = this.armorDAO.persist(armor);
        Optional<Armor> cond = this.armorDAO.findById(id);
        assertTrue(cond.isPresent());
        assertThat(armor, is(cond.get()));
    }

    @Test
    public void whenUpdateArmor() {
        Armor armor = new Armor(null, "gun", "power",
                1, 0, this.costume.getId());
        Integer id = this.armorDAO.persist(armor);
        armor.setId(id);
        armor.setArtifact("replace");
        this.armorDAO.update(armor);
        Armor result = armorDAO.findById(id).get();
        assertThat(armor.getArtifact(), is(result.getArtifact()));
        assertThat(armor, is(result));
    }

    @Test
    public void whenDeleteArmor() {
        Armor armor = new Armor(null, "delete", "delete",
                1, 0, this.costume.getId());
        Integer id = this.armorDAO.persist(armor);
        armor.setId(id);
        this.armorDAO.delete(armor);
        assertFalse(this.armorDAO.findAll().contains(armor));
    }

    @Test
    public void findAll() {
        Armor armor = new Armor(null, "nano coating", "stealth",
                1, 0, this.costume.getId());
        Integer id = this.armorDAO.persist(armor);
        assertTrue(this.armorDAO.findAll().contains(armor));
    }
}