package com.epam.as.mobilecomp.entities;

/**
 * General abstract class for all tariffs.
 */
public abstract class Tariff {

    private String name;


    public Tariff() {
    }

    /**
     * Construct new tariff with fee.
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
     * Return description about tariffs.
     */
    public abstract String getDescription();

    public abstract String getTariffType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tariff)) return false;

        Tariff tariff = (Tariff) o;

        return name.equals(tariff.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
