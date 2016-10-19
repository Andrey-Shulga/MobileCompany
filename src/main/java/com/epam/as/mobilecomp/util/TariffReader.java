package com.epam.as.mobilecomp.util;

import com.epam.as.mobilecomp.TariffFactory;
import com.epam.as.mobilecomp.entities.FeeTariff;
import com.epam.as.mobilecomp.entities.Tariff;
import com.epam.as.mobilecomp.entities.WithoutFeeTariff;

import java.util.HashMap;
import java.util.Map;

import static com.epam.as.mobilecomp.util.PropertyManager.propertyManager;

/**
 * Create tariff by reading parameters from property file "tariff.properties".
 * Use pattern "Factory".
 *
 * @see TariffFactory
 */
public class TariffReader {

    private static int tariffCount = 10;
    private static Tariff tariff;
    private static TariffFactory factory = new TariffFactory();
    private static Map<Tariff, Integer> tariffMap = new HashMap<>();

    /**
     * Create tariffs from file tariff.properties by using Factory.
     *
     * @return the list of tariff
     */
    public static Map<Tariff, Integer> createTariffByProperties() {
        for (int i = 1; i <= tariffCount; i++) {

            String tariffType = propertyManager.getProperty("tariff." + i + ".type");

            if (tariffType == null) break;
            if ((tariffType.equals("fee")) || (tariffType.equals("nofee"))) {

                tariff = factory.getTariff(tariffType);

                if (tariff.getTariffType().equals("fee")) {
                    String name = propertyManager.getProperty("tariff." + i + ".name");
                    int fee = propertyManager.getIntProperty("tariff." + i + ".fee");
                    int includedMinutes = propertyManager.getIntProperty("tariff." + i + ".includedMinutes");
                    int includedTraffic = propertyManager.getIntProperty("tariff." + i + ".includedTraffics");
                    tariff.setName(name);
                    ((FeeTariff) tariff).setFee(fee);
                    ((FeeTariff) tariff).setIncludedMinutes(includedMinutes);
                    ((FeeTariff) tariff).setIncludedTraffic(includedTraffic);
                }

                if (tariff.getTariffType().equals("nofee")) {
                    String name = propertyManager.getProperty("tariff." + i + ".name");
                    int callInNetCost = propertyManager.getIntProperty("tariff." + i + ".CallInNetCost");
                    int callOutNetCosts = propertyManager.getIntProperty("tariff." + i + ".CallOutNetCosts");
                    int trafficMbCost = propertyManager.getIntProperty("tariff." + i + ".TrafficMbCost");
                    tariff.setName(name);
                    ((WithoutFeeTariff) tariff).setCallInNetCost(callInNetCost);
                    ((WithoutFeeTariff) tariff).setCallOutNetCost(callOutNetCosts);
                    ((WithoutFeeTariff) tariff).setTrafficMbCost(trafficMbCost);
                }

                tariffMap.put(tariff, 0);
            }
        }
        return tariffMap;
    }
}
