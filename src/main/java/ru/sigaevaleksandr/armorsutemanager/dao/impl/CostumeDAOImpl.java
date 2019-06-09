package ru.sigaevaleksandr.armorsutemanager.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import ru.sigaevaleksandr.armorsutemanager.dao.CostumeDAO;
import ru.sigaevaleksandr.armorsutemanager.dao.util.CostumeExtractor;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Component
public class CostumeDAOImpl implements CostumeDAO {

    private final JdbcTemplate jdbcTemplate;

    public CostumeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int persist(Costume entity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        // language=sql
        String persistSql = "insert into costume (name_costume, max_count_armor) VALUES (?, ?)";
        //return this.jdbcTemplate.update(persistSql, entity.getNameCostume(), entity.getMaxCountArmor());
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(persistSql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, entity.getNameCostume());
            ps.setInt(2, entity.getMaxCountArmor());
            return ps;
        }, keyHolder);
        return keyHolder.getKeys().size() > 1 ? (Integer) keyHolder.getKeys().get("id") : keyHolder.getKey().intValue();
    }

    @Override
    public int update(Costume entity) {
        // language=sql
        String updateSql = "update costume set name_costume = ?, max_count_armor = ? where id = ?";
        return this.jdbcTemplate.update(updateSql, entity.getNameCostume(), entity.getMaxCountArmor(), entity.getId());
    }

    @Override
    public Optional<Costume> findById(Integer id) {
        // language=sql
        String findCostumeByIdSql = "select c.id as id_cos, c.name_costume, c.max_count_armor,"
                + " c.create_user_date, a.id as id_arm, a.name_armor, a.artifact"
                + " from costume c inner join armor a on c.id = a.id_costume where c.id = ?";

        List<Costume> resultQuery = this.jdbcTemplate.query(findCostumeByIdSql, new Object[]{id}, new CostumeExtractor());

        return resultQuery.stream().findFirst();
    }

    @Override
    public int delete(Costume entity) {
        // language=sql
        String deleteSql = "delete from costume where id = ?";
        return this.jdbcTemplate.update(deleteSql, entity.getId());
    }

    @Override
    public List<Costume> findAll() {
        // language=sql
        String findAllCostume = "select c.id as id_cos, c.name_costume, c.max_count_armor, c.create_user_date, "
                + "a.id as id_arm, a.name_armor, a.artifact from costume c "
                + "inner join armor a on c.id = a.id_costume order by c.id";

        return this.jdbcTemplate.query(findAllCostume, new CostumeExtractor());
    }
}
