package ru.sigaevaleksandr.armorsutemanager.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sigaevaleksandr.armorsutemanager.dao.ArmorDAO;
import ru.sigaevaleksandr.armorsutemanager.dao.util.ArmorMapper;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;

import java.util.List;
import java.util.Optional;

@Component
public class ArmorDAOImpl implements ArmorDAO {

    private final JdbcTemplate jdbcTemplate;

    public ArmorDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int persist(Armor entity) {
        // language=sql
        String persistSql = "insert into armor (id_costume, name_armor, artifact) values (?, ?, ?)";
        return jdbcTemplate.update(persistSql, entity.getIdCostume(), entity.getNameArmor(), entity.getArtifact());
    }

    @Override
    public int update(Armor entity) {
        // language=sql
        String persistSql = "update armor set name_armor = ?, artifact = ? where id = ?";
        return jdbcTemplate.update(persistSql, entity.getNameArmor(), entity.getArtifact(), entity.getId());
    }

    @Override
    public Optional<Armor> findById(Integer id) {
        // language=sql
        String findByIdSql = "select * into armor where id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(findByIdSql, new Object[] {id}, new ArmorMapper()));
    }

    @Override
    public int delete(Armor entity) {
        // language=sql
        String persistSql = "delete from armor where id = ?";
        return jdbcTemplate.update(persistSql, entity.getId());
    }

    @Override
    public List<Armor> findAll() {
        // language=sql
        String findAll = "select * into armor";
        return jdbcTemplate.query(findAll, new ArmorMapper());
    }
}
