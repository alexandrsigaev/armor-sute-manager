package ru.sigaevaleksandr.armorsutemanager.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.sigaevaleksandr.armorsutemanager.dao.UnitStoreDAO;
import ru.sigaevaleksandr.armorsutemanager.dao.util.UnitStoreMapper;
import ru.sigaevaleksandr.armorsutemanager.model.UnitStore;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Component
public class UnitStoreDAOImpl implements UnitStoreDAO {

    private final JdbcTemplate jdbcTemplate;

    public UnitStoreDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int persist(UnitStore entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        // language=sql
        String persistSql = "INSERT INTO store (id_armor, left_amount) VALUES (?, ?)";
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(persistSql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, entity.getArmorId());
            ps.setInt(2, entity.getAmountLeftInStorage());
            return ps;
        }, keyHolder);
        return (Integer) keyHolder.getKeys().get("id");
    }

    @Override
    public int update(UnitStore entity) {
        // language=sql
        String persistSql = "UPDATE store SET left_amount = ? where id_armor = ?";
        return jdbcTemplate.update(persistSql, entity.getAmountLeftInStorage(), entity.getArmorId());
    }

    @Override
    public Optional<UnitStore> findById(Integer id) {
        // language=sql
        String findByIdSql = "select * from store where id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(findByIdSql, new Object[] {id}, new UnitStoreMapper()));
    }

    @Override
    public int delete(UnitStore entity) {
        // language=sql
        String persistSql = "delete from store where id = ?";
        return jdbcTemplate.update(persistSql, entity.getId());
    }

    @Override
    public List<UnitStore> findAll() {
        // language=sql
        String findAll = "select * from store";
        return jdbcTemplate.query(findAll, new UnitStoreMapper());
    }
}
