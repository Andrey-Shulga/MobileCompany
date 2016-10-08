package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.entities.Tariff;

import java.util.Map;

/**
 * Create aggregate Mobile company.
 */
public class MobileCompany {
    private String name;
    private Map<Tariff, Integer> tariffMap;

    public MobileCompany(String name, Map<Tariff, Integer> tariffMap) {
        this.name = name;
        this.tariffMap = tariffMap;
    }

    public int getTariffNumberOfClients() {
        return (int) (Math.random() * 1500000);
    }
}
