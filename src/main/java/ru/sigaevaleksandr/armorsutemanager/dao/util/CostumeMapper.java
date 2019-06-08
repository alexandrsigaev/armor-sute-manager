package ru.sigaevaleksandr.armorsutemanager.dao.util;

import org.springframework.jdbc.core.RowMapper;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CostumeMapper implements RowMapper<Costume> {
    @Override
    public Costume mapRow(ResultSet resultSet, int i) throws SQLException {

        return null;
    }
}
