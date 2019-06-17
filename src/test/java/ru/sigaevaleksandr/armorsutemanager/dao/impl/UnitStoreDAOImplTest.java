package ru.sigaevaleksandr.armorsutemanager.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sigaevaleksandr.armorsutemanager.dao.ArmorDAO;
import ru.sigaevaleksandr.armorsutemanager.dao.UnitStoreDAO;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;
import ru.sigaevaleksandr.armorsutemanager.model.UnitStore;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnitStoreDAOImplTest {

    private Armor armor;
    @Autowired
    ArmorDAO armorDAO;
    @Autowired
    UnitStoreDAO unitStoreDAO;

    @Before
    public void setUp() throws Exception {
         armor = armorDAO.findAll().stream().findAny().get();
    }

    @Test
    public void whenPersist() {
        UnitStore store = new UnitStore(null, armor.getId(), 5000);
        Integer id = this.unitStoreDAO.persist(store);
        store.setId(id);
        Optional<UnitStore> cond = this.unitStoreDAO.findById(id);
        assertTrue(cond.isPresent());
        assertThat(store, is(cond.get()));
    }

    @Test
    public void whenUpdate() {
        UnitStore store = unitStoreDAO.findAll().get(0);
        store.setAmountLeftInStorage(300);
        this.unitStoreDAO.update(store);
        UnitStore result = this.unitStoreDAO.findById(store.getId()).get();
        assertThat(store.getAmountLeftInStorage(), is(result.getAmountLeftInStorage()));
        assertThat(store, is(result));
    }


    @Test
    public void whenDelete() {
        UnitStore store = unitStoreDAO.findAll().get(0);
        this.unitStoreDAO.delete(store);
        assertFalse(this.unitStoreDAO.findAll().contains(store));
    }

    @Test
    public void whenUpdateLeftAmountByArmorId() {
        UnitStore store = unitStoreDAO.findAll().get(0);
        store.setAmountLeftInStorage(400);
        this.unitStoreDAO.updateLeftAmountByArmorId(store);
        UnitStore result = this.unitStoreDAO.findById(store.getId()).get();
        assertThat(store.getAmountLeftInStorage(), is(result.getAmountLeftInStorage()));
        assertThat(store, is(result));
    }
}