package ru.sigaevaleksandr.armorsutemanager.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sigaevaleksandr.armorsutemanager.dao.ArmorDAO;
import ru.sigaevaleksandr.armorsutemanager.dao.util.ArmorMapper;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;

import java.util.List;

@Component
public class ArmorDAOImpl implements ArmorDAO {

    private final JdbcTemplate jdbcTemplate;

    public ArmorDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void persist(Armor entity) {
        // language=sql
        String persistSql = "insert into armor (id_costume, name_armor, artifact) values (?, ?, ?)";
        jdbcTemplate.update(persistSql, entity.getCostume().getId(), entity.getNameArmor(), entity.getArtifact());
    }

    @Override
    public void update(Armor entity) {
        // language=sql
        String persistSql = "update armor set name_armor = ?, artifact = ? where id = ?";
        jdbcTemplate.update(persistSql, entity.getNameArmor(), entity.getArtifact(), entity.getId());
    }

    @Override
    public Armor findById(Integer id) {
        // language=sql
        String findByIdSql = "select * into armor where id = ?";
        return jdbcTemplate.queryForObject(findByIdSql, new Object[] {id}, new ArmorMapper());
    }

    @Override
    public void delete(Armor entity) {
        // language=sql
        String persistSql = "delete from armor where id = ?";
        jdbcTemplate.update(persistSql, entity.getId());
    }

    @Override
    public List<Armor> findAll() {
        // language=sql
        String findAll = "select * into armor";
        return jdbcTemplate.query(findAll, new ArmorMapper());
    }
}
