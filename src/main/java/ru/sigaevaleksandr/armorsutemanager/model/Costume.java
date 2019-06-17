package ru.sigaevaleksandr.armorsutemanager.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Costume {
    private Integer id;
    private String nameCostume;
    private Integer maxCountArmor;
    private CostumeType type;
    private List<Armor> armors;
    private CostumeStatus status;
    private LocalDate createDate;

    public Costume() {
    }

    public Costume(Integer id, String nameCostume, Integer maxCountArmor, CostumeType type, List<Armor> armors,
                   CostumeStatus status) {
        this.id = id;
        this.nameCostume = nameCostume;
        this.maxCountArmor = maxCountArmor;
        this.type = type;
        this.armors = armors;
        this.status = status;
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

    public CostumeStatus getStatus() {
        return status;
    }

    public void setStatus(CostumeStatus status) {
        this.status = status;
    }

    public String getLoadArmor() {
        double load = 0;
        if (maxCountArmor != null && armors != null) {
            double tmp = 0d;
            for (Armor arm : this.armors) {
                tmp += arm.getLoadUnit();
            }
            load = tmp / maxCountArmor;
        }
        return String.format("%.0f", load * 100);
    }

    public CostumeType getType() {
        return type;
    }

    public void setType(CostumeType type) {
        this.type = type;
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
                && type == costume.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCostume, type);
    }

    @Override
    public String toString() {
        return "Costume{"
                + "id=" + id
                + ", nameCostume='" + nameCostume + '\''
                + ", maxCountArmor=" + maxCountArmor
                + ", createDate=" + createDate
                + '}';
    }
}
