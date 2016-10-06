package com.epam.as.mobilecomp.tariffs.fee;

import com.epam.as.mobilecomp.tariffs.Tariffs;

/**
 * Class for tariffs with subscription fee.
 */
public class FeeTariffs extends Tariffs implements Comparable<FeeTariffs> {
    private int fee;
    private int includeMinutes;
    private int includeTraffic;


    /**
     * Construct new tariff with fee.
     *
     * @param name           the name of new tariff
     * @param customers      amount of customers
     * @param isHasFee       has or not fee
     * @param fee            cost of fee per month.
     * @param includeMinutes number of free time (minutes) included in tariff
     * @param includeTraffic number of free traffic (mbytes) included in tariff
     */
    public FeeTariffs(String name, int customers, boolean isHasFee, int fee, int includeMinutes, int includeTraffic) {
        super(name, customers, isHasFee);
        this.fee = fee;
        this.includeMinutes = includeMinutes;
        this.includeTraffic = includeTraffic;

    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getIncludeMinutes() {
        return includeMinutes;
    }

    public void setIncludeMinutes(int includeMinutes) {
        this.includeMinutes = includeMinutes;
    }

    public int getIncludeTraffic() {
        return includeTraffic;
    }

    public void setIncludeTraffic(int includeTraffic) {
        this.includeTraffic = includeTraffic;
    }

    /**
     * Return description about tariff with parameters.
     *
     * @return description about tariff with parameters
     */
    public String getDescription() {
        return "Tariff \"" + getName() + "\".  This tariff with subscription fee " + getFee() + " per month. Included free " + getIncludeMinutes() + " min. and " +
                getIncludeTraffic() + " mbs.";
    }


    public int compareTo(FeeTariffs other) {
        return Integer.compare(fee, other.fee);
    }


}