package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.entities.Tariff;

import java.util.Map;

/**
 * Create aggregate Mobile company.
 *
 */
public class MobileCompany {
    private String name;
    private Map<Tariff, Integer> tariffMap;
    private int RANDOM_RANGE = 1500000;

    /**
     * Constructs new Mobile Company
     *
     * @param name      the name of Mobile Company
     * @param tariffMap the list of tariffs for Mobile Company
     */
    public MobileCompany(String name, Map<Tariff, Integer> tariffMap) {
        this.name = name;
        this.tariffMap = tariffMap;
    }

    /**
     * Generate random number of clients for tariff.
     *
     * @return random number of clients for tariff
     * */
    public int getTariffNumberOfClients() {
        return (int) (Math.random() * RANDOM_RANGE);
    }
}
