package ru.sigaevaleksandr.armorsutemanager.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Costume {
    private Integer id;
    private String nameCostume;
    private Integer maxCountArmor;
    private LocalDate createDate;
    private List<Armor> armors;

    public Costume() {
    }

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

    public Integer getMaxCountArmor() {
        return maxCountArmor;
    }

    public void setMaxCountArmor(Integer maxCountArmor) {
        this.maxCountArmor = maxCountArmor;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public List<Armor> getArmors() {
        return armors;
    }

    public void setArmors(List<Armor> armors) {
        this.armors = armors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Costume costume = (Costume) o;
        return Objects.equals(nameCostume, costume.nameCostume)
                && Objects.equals(createDate, costume.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCostume, createDate);
    }

    @Override
    public String toString() {
        return "Costume{"
                + "id=" + id
                + ", nameCostume='" + nameCostume + '\''
                + ", maxCountArmor=" + maxCountArmor
                + ", createDate=" + createDate
                + ", armors=" + armors
                + '}';
    }
}
