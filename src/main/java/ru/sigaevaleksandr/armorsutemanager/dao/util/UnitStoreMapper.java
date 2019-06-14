package ru.sigaevaleksandr.armorsutemanager.dao.util;

import org.springframework.jdbc.core.RowMapper;
import ru.sigaevaleksandr.armorsutemanager.model.UnitStore;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitStoreMapper implements RowMapper<UnitStore> {
    @Override
    public UnitStore mapRow(ResultSet rs, int i) throws SQLException {
        return new UnitStore(
                rs.getInt("id"),
                rs.getInt("id_armor"),
                rs.getInt("left_amount")
        );
    }
}
