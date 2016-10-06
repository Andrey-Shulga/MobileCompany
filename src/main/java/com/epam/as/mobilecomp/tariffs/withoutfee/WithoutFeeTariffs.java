package com.epam.as.mobilecomp.tariffs.withoutfee;

import com.epam.as.mobilecomp.tariffs.Tariffs;

/**
 * General class for tariffs without subscription fee.
 */
public class WithoutFeeTariffs extends Tariffs {

    private int costCallInNet;
    private int costCallOutNet;
    private int costTraffic;

    /**
     * Construct new tariff without fee.
     *
     * @param name      the name of new tariff
     * @param customers amount of customers
     * @param isHasFee  has or not fee
     * @param costCallInNet cost of call in network per minute
     * @param costCallOutNet cost of call out network pre minute
     */
    public WithoutFeeTariffs(String name, int customers, boolean isHasFee, int costCallInNet, int costCallOutNet, int costTraffic) {
        super(name, customers, isHasFee);
        this.costCallInNet = costCallInNet;
        this.costCallOutNet = costCallOutNet;
        this.costTraffic = costTraffic;
    }

    /**
     * Return description about tariff with parameters.
     */
    public String getDescription() {
        return null;
    }
}
