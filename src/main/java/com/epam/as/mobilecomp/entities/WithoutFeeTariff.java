package com.epam.as.mobilecomp.entities;

/**
 * General entities without subscription fee, for all country.
 */
public class WithoutFeeTariff extends Tariff {

    private int CallInNetCost;
    private int CallOutNetCost;
    private int TrafficMbCost;

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
        this.CallInNetCost = CallInNetCost;
        this.CallOutNetCost = CallOutNetCost;
        this.TrafficMbCost = TrafficMbCost;
    }

    public int getCallInNetCost() {
        return CallInNetCost;
    }

    public void setCallInNetCost(int callInNetCost) {
        this.CallInNetCost = callInNetCost;
    }

    public int getCallOutNetCost() {
        return CallOutNetCost;
    }

    public void setCallOutNetCost(int callOutNetCost) {
        this.CallOutNetCost = callOutNetCost;
    }

    public int getTrafficMbCost() {
        return TrafficMbCost;
    }

    public void setTrafficMbCost(int trafficMbCost) {
        this.TrafficMbCost = trafficMbCost;
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
