package ru.sigaevaleksandr.armorsutemanager.model;

import java.util.Objects;

public class Armor {
    private Integer id;
    private String nameArmor;
    private String artifact;
    private Integer idCostume;
    public Armor() {
    }

    public Armor(Integer id, String nameArmor, String artifact, Integer idCostume) {
        this.id = id;
        this.nameArmor = nameArmor;
        this.artifact = artifact;
        this.idCostume = idCostume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameArmor() {
        return nameArmor;
    }

    public void setNameArmor(String nameArmor) {
        this.nameArmor = nameArmor;
    }

    public String getArtifact() {
        return artifact;
    }

    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }

    public Integer getIdCostume() {
        return idCostume;
    }

    public void setIdCostume(Integer idCostume) {
        this.idCostume = idCostume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Armor armor = (Armor) o;
        return Objects.equals(nameArmor, armor.nameArmor)
                && Objects.equals(artifact, armor.artifact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameArmor, artifact);
    }

    @Override
    public String toString() {
        return "Armor{"
                + "id=" + id
                + ", nameArmor='" + nameArmor + '\''
                + ", artifact='" + artifact + '\''
                + ", idCostume=" + idCostume
                + '}';
    }
}
