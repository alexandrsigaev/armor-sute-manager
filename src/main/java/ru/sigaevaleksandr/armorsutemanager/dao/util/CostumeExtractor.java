package ru.sigaevaleksandr.armorsutemanager.dao.util;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import ru.sigaevaleksandr.armorsutemanager.model.Armor;
import ru.sigaevaleksandr.armorsutemanager.model.Costume;
import ru.sigaevaleksandr.armorsutemanager.model.CostumeStatus;
import ru.sigaevaleksandr.armorsutemanager.model.CostumeType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CostumeExtractor implements ResultSetExtractor<List<Costume>> {

    @Override
    public List<Costume> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, Costume> map = new HashMap<>();
        while (rs.next()) {
            Integer cosId = rs.getInt("id_cos");
            Costume costume = map.get(cosId);
            if (costume == null) {
                costume = new Costume();
                costume.setId(cosId);
                costume.setNameCostume(rs.getString("name_costume"));
                costume.setMaxCountArmor(rs.getInt("max_count_armor"));
                costume.setType(CostumeType.valueOf(rs.getString("type")));
                costume.setStatus(CostumeStatus.valueOf(rs.getString("status")));
                costume.setCreateDate(rs.getDate("create_user_date").toLocalDate());
                costume.setArmors(new ArrayList<>());
                map.put(cosId, costume);
            }
            int idArmor = rs.getInt("id_arm");
            if (idArmor == 0) {
                continue;
            }
            Armor armor = new Armor();
            armor.setId(idArmor);
            armor.setNameArmor(rs.getString("name_armor"));
            armor.setArtifact(rs.getString("artifact"));
            armor.setUnitMax(rs.getInt("unit_max"));
            armor.setIdCostume(rs.getInt("id_cos"));
            costume.getArmors().add(armor);
        }
        return new ArrayList<Costume>(map.values());
    }
}
