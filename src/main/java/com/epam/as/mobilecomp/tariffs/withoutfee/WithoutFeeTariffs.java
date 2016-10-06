package com.epam.as.mobilecomp.tariffs.withoutfee;

import com.epam.as.mobilecomp.tariffs.Tariffs;

/**
 * General tariff without subscription fee, for all country.
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
     * @param costCallOutNet cost of call out network per minute
     * @param costTraffic cost of traffic per mbytes
     */
    public WithoutFeeTariffs(String name, int customers, boolean isHasFee, int costCallInNet, int costCallOutNet, int costTraffic) {
        super(name, customers, isHasFee);
        this.costCallInNet = costCallInNet;
        this.costCallOutNet = costCallOutNet;
        this.costTraffic = costTraffic;
    }

    public int getCostCallInNet() {
        return costCallInNet;
    }

    public void setCostCallInNet(int costCallInNet) {
        this.costCallInNet = costCallInNet;
    }

    public int getCostCallOutNet() {
        return costCallOutNet;
    }

    public void setCostCallOutNet(int costCallOutNet) {
        this.costCallOutNet = costCallOutNet;
    }

    public int getCostTraffic() {
        return costTraffic;
    }

    public void setCostTraffic(int costTraffic) {
        this.costTraffic = costTraffic;
    }

    /**
     * Return description about tariff without fee, with parameters.
     *
     * @return description about tariff without fee, with parameters.
     */
    public String getDescription() {
        return "Tariff \"" + getName() + "\".  This tariff without subscription fee, cost of in-net call " + getCostCallInNet() + " (per min.), cost of out-net call "
                + getCostCallOutNet() + " (per min.), cost of traffic " + getCostTraffic() + " (per Mb).";
    }
}
