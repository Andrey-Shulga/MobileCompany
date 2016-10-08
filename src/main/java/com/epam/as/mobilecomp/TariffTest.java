package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.entities.FeeTariff;
import com.epam.as.mobilecomp.entities.Tariff;
import com.epam.as.mobilecomp.entities.WithoutFeeTariff;

import java.util.HashMap;
import java.util.Map;

import static com.epam.as.mobilecomp.util.PropertyManager.propertyManager;

/**
 * This program demonstrates actions with entities of Mobile Company.
 *
 * @author Andrey Shulga
 * @version 1.0 2016-10-06
 */

public class TariffTest {

    public static void main(String[] args) {
        final int tariffCount = 9;
        TariffFactory factory = new TariffFactory();
        Map<Tariff, Integer> tariffMap = new HashMap<>();
        MobileCompany company = new MobileCompany("ECell", tariffMap);
        TariffService tariffService = new TariffService();

        //Create tariffs from file tariff.properties by using Factory method.
        for (int i = 1; i <= tariffCount; i++) {

            String tariffType = propertyManager.getProperty("tariff." + i + ".type");
            if (tariffType == null) break;

            Tariff tariff = factory.getTariff(tariffType);

            if (tariff instanceof FeeTariff) {
                String name = propertyManager.getProperty("tariff." + i + ".name");
                int fee = propertyManager.getIntProperty("tariff." + i + ".fee");
                int includedMinutes = propertyManager.getIntProperty("tariff." + i + ".includedMinutes");
                int includedTraffic = propertyManager.getIntProperty("tariff." + i + ".includedTraffics");
                tariff.setName(name);
                ((FeeTariff) tariff).setFee(fee);
                ((FeeTariff) tariff).setIncludedMinutes(includedMinutes);
                ((FeeTariff) tariff).setIncludedTraffic(includedTraffic);
            }
            if (tariff instanceof WithoutFeeTariff) {
                String name = propertyManager.getProperty("tariff." + i + ".name");
                int callInNetCost = propertyManager.getIntProperty("tariff." + i + ".CallInNetCost");
                int callOutNetCosts = propertyManager.getIntProperty("tariff." + i + ".CallOutNetCosts");
                int trafficMbCost = propertyManager.getIntProperty("tariff." + i + ".TrafficMbCost");
                tariff.setName(name);
                ((WithoutFeeTariff) tariff).setCallInNetCost(callInNetCost);
                ((WithoutFeeTariff) tariff).setCallOutNetCost(callOutNetCosts);
                ((WithoutFeeTariff) tariff).setTrafficMbCost(trafficMbCost);
            }

            tariffMap.put(tariff, company.getTariffNumberOfClients());
        }
        tariffService.printTariffsToConsole(tariffMap);
        tariffService.calculateAllCustomers(tariffMap);
        tariffService.sortTariffsByFee(tariffMap);

        int fromMin = 150;
        int toMin = 250;
        int fromMb = 1000;
        int toMb = 2500;
        tariffService.findTariffByParams(tariffMap, fromMin, toMin, fromMb, toMb);
    }
}
