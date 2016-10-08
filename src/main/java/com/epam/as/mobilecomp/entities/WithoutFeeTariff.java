package com.epam.as.mobilecomp.entities;

/**
 * General entities without subscription fee, for all country.
 */
public class WithoutFeeTariff extends Tariff {

    private int callInNetCost;
    private int callOutNetCost;
    private int trafficMbCost;

    public WithoutFeeTariff() {
    }

    /**
     * Construct new entities without fee.
     *
     * @param name           the name of new tariff
     * @param CallInNetCost  cost of call in network per minute
     * @param CallOutNetCost cost of call out network per minute
     * @param TrafficMbCost  cost of traffic per mbytes
     */
    public WithoutFeeTariff(String name, int CallInNetCost, int CallOutNetCost, int TrafficMbCost) {
        super(name);
        this.callInNetCost = CallInNetCost;
        this.callOutNetCost = CallOutNetCost;
        this.trafficMbCost = TrafficMbCost;
    }

    public int getCallInNetCost() {
        return callInNetCost;
    }

    public void setCallInNetCost(int callInNetCost) {
        this.callInNetCost = callInNetCost;
    }

    public int getCallOutNetCost() {
        return callOutNetCost;
    }

    public void setCallOutNetCost(int callOutNetCost) {
        this.callOutNetCost = callOutNetCost;
    }

    public int getTrafficMbCost() {
        return trafficMbCost;
    }

    public void setTrafficMbCost(int trafficMbCost) {
        this.trafficMbCost = trafficMbCost;
    }

    /**
     * Return description about entities without fee, with parameters.
     *
     * @return description about entities without fee, with parameters.
     */
    public String getDescription() {
        return "Tariff \"" + getName() + "\".  This entities without subscription fee, cost of in-net call " + getCallInNetCost() + " (per min.), cost of out-net call "
                + getCallOutNetCost() + " (per min.), cost of traffic " + getTrafficMbCost() + " (per Mb).";
    }

    @Override
    public String getTariffType() {
        return "nofee";
    }
}
