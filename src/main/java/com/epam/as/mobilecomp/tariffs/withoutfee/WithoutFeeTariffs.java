package com.epam.as.mobilecomp.tariffs.withoutfee;

import com.epam.as.mobilecomp.tariffs.Tariffs;

/**
 * Class for tariffs without subscription fee.
 */
public class WithoutFeeTariffs extends Tariffs {

    private int callCost;

    /**
     * Construct new tariff without fee.
     *
     * @param name      the name of new tariff
     * @param customers amount of customers
     * @param isHasFee  has or not fee
     */
    WithoutFeeTariffs(String name, int customers, boolean isHasFee) {
        super(name, customers, isHasFee);
    }

    /**
     * Return description about tariff with parameters.
     */
    public String getDescription() {
        return null;
    }
}
