package ru.sigaevaleksandr.armorsutemanager.model;

import java.util.List;

public class Costume {
    Integer id;
    String nameCostume;
    int maxCountArmor;
    List<Armor> armors;

    public Costume(Integer id, String nameCostume, int maxCountArmor, List<Armor> armors) {
        this.id = id;
        this.nameCostume = nameCostume;
        this.maxCountArmor = maxCountArmor;
        this.armors = armors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCostume() {
        return nameCostume;
    }

    public void setNameCostume(String nameCostume) {
        this.nameCostume = nameCostume;
    }

    public int getMaxCountArmor() {
        return maxCountArmor;
    }

    public void setMaxCountArmor(int maxCountArmor) {
        this.maxCountArmor = maxCountArmor;
    }

    public List<Armor> getArmors() {
        return armors;
    }

    public void setArmors(List<Armor> armors) {
        this.armors = armors;
    }
}
