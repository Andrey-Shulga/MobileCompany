package com.epam.as.mobilecomp.entities;

/**
 * Class for entities with subscription fee.
 */
public class FeeTariff extends Tariff {
    private int fee;
    private int includedMinutes;
    private int includedTraffic;

    public FeeTariff() {

    }

    /**
     * Construct new entities with fee.
     *
     * @param name           the name of new tariff
     * @param fee            cost of fee per month.
     * @param includedMinutes number of free time (minutes) included in entities
     * @param includedTraffic number of free traffic (mbytes) included in entities
     */
    public FeeTariff(String name, int fee, int includedMinutes, int includedTraffic) {
        super(name);
        this.fee = fee;
        this.includedMinutes = includedMinutes;
        this.includedTraffic = includedTraffic;

    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getIncludedMinutes() {
        return includedMinutes;
    }

    public void setIncludedMinutes(int includedMinutes) {
        this.includedMinutes = includedMinutes;
    }

    public int getIncludedTraffic() {
        return includedTraffic;
    }

    public void setIncludedTraffic(int includedTraffic) {
        this.includedTraffic = includedTraffic;
    }

    /**
     * Return description about entities with parameters.
     *
     * @return description about entities with parameters
     */
    public String getDescription() {
        return "Tariff \"" + getName() + "\".  This entities with subscription fee " + getFee() + " per month. Included free " + getIncludedMinutes() + " min. and " +
                getIncludedTraffic() + " mbs.";
    }

    /**
     * Return description about entities with parameters.
     *
     * @return description about entities with parameters
     */
    @Override
    public String getTariffType() {
        return "fee";
    }

    @Override
    public String toString() {
        return getName();
    }
}