package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.entities.Tariff;
import com.epam.as.mobilecomp.util.TariffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * This program tests actions with tariffs of some Mobile Company.
 *
 * @author Andrey Shulga
 * @version 1.0 2016-10-06
 */

public class TariffTest {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger("com.epam.as.mobilecomp.TariffTest");

        // Create tariffs' list
        Map<Tariff, Integer> tariffList = TariffBuilder.createTariffByProperties();

        //Create new Mobile Company with tariffs' list
        MobileCompany company = new MobileCompany("ECell", tariffList);

        // Fill each tariff by clients
        for (Map.Entry<Tariff, Integer> tariff : tariffList.entrySet()) {
            int clients = company.getTariffNumberOfClients();
            tariff.setValue(clients);
        }

        TariffService tariffService = new TariffService();

        logger.info("The list of all tariffs:");
        tariffService.printTariffsToConsole(tariffList);

        logger.info("Total customers:");
        tariffService.calculateAllCustomers(tariffList);

        logger.info("Sort tariffs by fee:");
        tariffService.sortTariffsByFee(tariffList);

        logger.info("Search tariff by range of parameters:");
        int fromMin = 150;
        int toMin = 250;
        int fromMb = 1000;
        int toMb = 2500;
        tariffService.findTariffByParams(tariffList, fromMin, toMin, fromMb, toMb);
    }
}
