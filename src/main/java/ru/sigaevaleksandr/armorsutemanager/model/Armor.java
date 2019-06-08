package ru.sigaevaleksandr.armorsutemanager.model;

import java.util.Objects;

public class Armor {
    private Integer id;
    private String nameArmor;
    private String artifact;
    private Costume costume;

    public Armor() {
    }

    public Armor(Integer id, String nameArmor, String artifact, Costume costume) {
        this.id = id;
        this.nameArmor = nameArmor;
        this.artifact = artifact;
        this.costume = costume;
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

    public Costume getCostume() {
        return costume;
    }

    public void setCostume(Costume costume) {
        this.costume = costume;
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
                && Objects.equals(artifact, armor.artifact)
                && Objects.equals(costume, armor.costume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameArmor, artifact, costume);
    }
}
