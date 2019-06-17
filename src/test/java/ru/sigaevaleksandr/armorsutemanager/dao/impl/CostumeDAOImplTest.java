package ru.sigaevaleksandr.armorsutemanager.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sigaevaleksandr.armorsutemanager.dao.ArmorDAO;
import ru.sigaevaleksandr.armorsutemanager.dao.CostumeDAO;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;
import ru.sigaevaleksandr.armorsutemanager.model.CostumeStatus;
import ru.sigaevaleksandr.armorsutemanager.model.CostumeType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CostumeDAOImplTest {

    @Autowired
    ArmorDAO armorDAO;
    @Autowired
    CostumeDAO costumeDAO;
    LocalDate date = LocalDate.now();

    @Test
    public void whenCostumePersist() {
        Costume costume = new Costume(null, "MARK_PER", 5,
                CostumeType.WARRIOR, new ArrayList<>(), CostumeStatus.RELEASE);
        costume.setCreateDate(date);
        Integer id = this.costumeDAO.persist(costume);
        costume.setId(id);
        Optional<Costume> cond = this.costumeDAO.findById(id);
        assertTrue(cond.isPresent());
        assertThat(costume, is(cond.get()));
    }

    @Test
    public void whenCostumeUpdate() {
        Costume costume = new Costume(null, "MARK_UPD", 4,
                CostumeType.ASTRONAUT, new ArrayList<>(), CostumeStatus.PROTOTYPE);
        costume.setCreateDate(date);
        Integer id = this.costumeDAO.persist(costume);
        costume.setId(id);
        costume.setMaxCountArmor(6);
        costume.setType(CostumeType.WARRIOR);
        costume.setStatus(CostumeStatus.RELEASE);
        this.costumeDAO.update(costume);
        Costume result = this.costumeDAO.findById(id).get();
        assertThat(costume.getMaxCountArmor(), is(result.getMaxCountArmor()));
        assertThat(costume.getStatus(), is(CostumeStatus.RELEASE));
        assertThat(costume.getType(), is(CostumeType.WARRIOR));
        assertThat(costume, is(result));
    }

    @Test
    public void whenCostumeDelete() {
        Costume costume = new Costume(null, "MARK_DEL", 6,
                CostumeType.WARRIOR, new ArrayList<>(), CostumeStatus.RELEASE);
        costume.setCreateDate(date);
        Integer id = this.costumeDAO.persist(costume);
        costume.setId(id);
        this.costumeDAO.delete(costume);
        assertFalse(this.costumeDAO.findAll().contains(costume));
    }

    @Test
    public void findCostumesByParam() {
        Costume costume = new Costume(null, "MARK_FIND_PARAM", 6,
                CostumeType.WARRIOR, new ArrayList<>(), CostumeStatus.RELEASE);
        costume.setCreateDate(date);
        Integer cosId = this.costumeDAO.persist(costume);
        costume.setId(cosId);
        Armor armor = new Armor(null, "nano coating", "stealth",
                1, 0, costume.getId());
        Integer armId = this.armorDAO.persist(armor);
        armor.setId(armId);
        costume.getArmors().add(armor);
        assertTrue(this.costumeDAO.findCostumesByParam("stealth").contains(costume));
    }
}