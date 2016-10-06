package com.epam.as.mobilecomp.tarrifs;

/**
 * General abstract class for all tariffs.
 */
public abstract class Tariffs {

    private String name;
    private int customers;

    /**
     * Construct new tariff.
     * @param name the name of new tariff
     * @param customers amount of customers
     */
    public Tariffs(String name, int customers){
        this.name=name;
        this.customers=customers;
    }

    public String getName(){
        return name;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    /**
     * Return description about tariff.
     */
    public abstract String getDescription();

}
