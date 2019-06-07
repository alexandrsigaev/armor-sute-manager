package ru.sigaevaleksandr.armorsutemanager.model;

public class Armor {
    Integer id;
    String nameArmor;
    String artifact;

    public Armor(Integer id, String nameArmor, String artifact) {
        this.id = id;
        this.nameArmor = nameArmor;
        this.artifact = artifact;
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
}
