package com.epam.as.mobilecomp.tariffs.withoutfee;

/**
 * Tariffs without subscription fee, for a particular region.
 */
public class RegionalTariffs extends WithoutFeeTariffs {
    private String region;

    /**
     * Construct new tariff for any region without fee.
     *
     * @param name           the name of new tariff
     * @param customers      amount of customers
     * @param isHasFee       has or not fee
     * @param costCallInNet  cost of call in network per minute
     * @param costCallOutNet cost of call out network per minute
     * @param costTraffic    cost of traffic per mbytes
     * @param region         the name of region
     */
    public RegionalTariffs(String name, int customers, boolean isHasFee, String region, int costCallInNet, int costCallOutNet, int costTraffic) {
        super(name, customers, isHasFee, costCallInNet, costCallOutNet, costTraffic);
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Return description about tariff without fee, with parameters.
     *
     * @return description about regional tariff without fee, with parameters.
     */
    @Override
    public String getDescription() {
        return "Only for region " + getRegion() + "! " + super.getDescription();
    }
}
