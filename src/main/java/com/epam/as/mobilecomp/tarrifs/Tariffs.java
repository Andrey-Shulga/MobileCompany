package com.epam.as.mobilecomp.tarrifs;

/**
 * General abstract class for all tariffs.
 */
abstract class Tariffs {

    private String name;
    private int customers;
    private boolean isHasFee;

    /**
     * Construct new tariff.
     *
     * @param name the name of new tariff
     * @param customers amount of customers
     * @param isHasFee has or not fee
     */
    Tariffs(String name, int customers, boolean isHasFee) {
        this.name=name;
        this.customers=customers;
        this.isHasFee = isHasFee;
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

    public boolean isHasFee() {
        return isHasFee;
    }

    /**
     * Return description about tariff.
     */
    public abstract String getDescription();
}
