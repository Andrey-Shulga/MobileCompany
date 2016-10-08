package com.epam.as.mobilecomp.entities;

/**
 * General abstract class for all entities.
 */
public abstract class Tariff {

    private String name;

    public Tariff() {
    }

    /**
     * Construct new entities with fee.
     *
     * @param name the name of new tariff
     */
    public Tariff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return description about entities.
     */
    public abstract String getDescription();

    public abstract String getTariffType();

}
