package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.entities.Tariff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Create aggregate Mobile company.
 *
 */
public class MobileCompany {
    private String name;
    private Map<Tariff, Integer> tariffMap;
    private int RANDOM_RANGE = 1500000;
    Logger logger = LoggerFactory.getLogger(MobileCompany.class);

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

    /**
     * Get number of customers for all tariff.
     *
     * @param tariffMap the list of tariff
     */
    public int getLogAllCustomers(Map<Tariff, Integer> tariffMap) {
        int count = 0;

        for (Map.Entry m : tariffMap.entrySet())
            count += Integer.parseInt(m.getValue().toString());
        return count;
    }
}
