package ru.sigaevaleksandr.armorsutemanager.dao.util;

import org.springframework.jdbc.core.RowMapper;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArmorMapper implements RowMapper<Armor> {
    @Override
    public Armor mapRow(ResultSet rs, int rn) throws SQLException {
        Armor armor = new Armor();
        armor.setId(rs.getInt("id"));
        armor.setNameArmor(rs.getString("name_armor"));
        armor.setArtifact(rs.getString("artifact"));
        armor.setUnitMax(rs.getInt("unit_max"));
        armor.setIdCostume(rs.getInt("id_costume"));
        return armor;
    }
}
