package ru.sigaevaleksandr.armorsutemanager.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.sigaevaleksandr.armorsutemanager.dao.CostumeDAO;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;

import java.util.List;

@Component
public class CostumeDAOImpl implements CostumeDAO {

    private final JdbcTemplate jdbcTemplate;

    public CostumeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void persist(Costume entity) {
        // language=sql
        String persistSql = "insert into costume (name_costume, max_count_armor) VALUES (?, ?)";
        this.jdbcTemplate.update(persistSql, entity.getNameCostume(), entity.getMaxCountArmor());
    }

    @Override
    public void update(Costume entity) {
        // language=sql
        String updateSql = "update costume set name_costume = ?, max_count_armor = ? where id = ?";
        this.jdbcTemplate.update(updateSql, entity.getNameCostume(), entity.getMaxCountArmor(), entity.getId());
    }

    @Override
    public Costume findById(Integer integer) {
        // language=sql
        String findCostumeByIdSql = "select c.id as id_cos, c.name_costume, c.max_count_armor,"
                + " c.create_user_date, a.id as id_arm, a.name_armor, a.artifact"
                + " from costume c inner join armor a on c.id = a.id_costume where c.id = 1";


        return null;
    }

    @Override
    public void delete(Costume entity) {
        // language=sql
        String deleteSql = "delete from costume where id = ?";
        this.jdbcTemplate.update(deleteSql, entity.getId());
    }

    @Override
    public List<Costume> findAll() {
        // language=sql
        String findAllCostume = "select c.id as id_cos, c.name_costume, c.max_count_armor, c.create_user_date, "
                + "a.id as id_arm, a.name_armor, a.artifact from costume c "
                + "inner join armor a on c.id = a.id_costume order by c.id";

        return null;
    }
}
