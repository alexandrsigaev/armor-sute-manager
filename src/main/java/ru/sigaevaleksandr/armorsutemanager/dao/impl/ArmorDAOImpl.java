package ru.sigaevaleksandr.armorsutemanager.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.sigaevaleksandr.armorsutemanager.dao.ArmorDAO;
import ru.sigaevaleksandr.armorsutemanager.dao.util.ArmorMapper;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;

import java.sql.PreparedStatement;
import java.sql.Statement;
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
        KeyHolder keyHolder = new GeneratedKeyHolder();
        // language=sql
        String persistSql = "INSERT INTO armor (id_costume, name_armor, artifact, unit_max) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(persistSql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, entity.getIdCostume());
            ps.setString(2, entity.getNameArmor());
            ps.setString(3, entity.getArtifact());
            ps.setInt(4, entity.getUnitMax());
            return ps;
        }, keyHolder);
        return (Integer) keyHolder.getKeys().get("id");
    }

    @Override
    public int update(Armor entity) {
        // language=sql
        String persistSql = "UPDATE armor SET name_armor = ?, artifact = ?, unit_max = ? WHERE id = ?";
        return jdbcTemplate.update(persistSql, entity.getNameArmor(), entity.getArtifact(),
                entity.getUnitMax(), entity.getId());
    }

    @Override
    public Optional<Armor> findById(Integer id) {
        // language=sql
        String findByIdSql = "select * from armor where id = ?";
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
        String findAll = "select * from armor";
        return jdbcTemplate.query(findAll, new ArmorMapper());
    }
}
