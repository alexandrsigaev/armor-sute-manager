package ru.sigaevaleksandr.armorsutemanager.model;

import java.util.Objects;

public class UnitStore {
    private Integer id;
    private Integer armorId;
    private int amountLeftInStorage;

    public UnitStore() {
    }

    public UnitStore(Integer id, Integer armorId, int amountLeftInStorage) {
        this.id = id;
        this.armorId = armorId;
        this.amountLeftInStorage = amountLeftInStorage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArmorId() {
        return armorId;
    }

    public void setArmorId(Integer armorId) {
        this.armorId = armorId;
    }

    public int getAmountLeftInStorage() {
        return amountLeftInStorage;
    }

    public void setAmountLeftInStorage(int amountLeftInStorage) {
        this.amountLeftInStorage = amountLeftInStorage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UnitStore unitStore = (UnitStore) o;
        return amountLeftInStorage == unitStore.amountLeftInStorage
                && Objects.equals(armorId, unitStore.armorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(armorId, amountLeftInStorage);
    }
}
