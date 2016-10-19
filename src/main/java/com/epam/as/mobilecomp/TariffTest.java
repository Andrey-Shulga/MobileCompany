package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.entities.FeeTariff;
import com.epam.as.mobilecomp.entities.Tariff;
import com.epam.as.mobilecomp.service.TariffService;
import com.epam.as.mobilecomp.util.TariffReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

/**
 * This program tests actions with tariffs of some Mobile Company.
 *
 * @author Andrey Shulga
 * @version 1.0 2016-10-06
 */

public class TariffTest {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(TariffTest.class);
        TariffService tariffService = new TariffService();
        Set<FeeTariff> sortedList;

        // Create tariffs' list
        Map<Tariff, Integer> tariffList = TariffReader.createTariffByProperties();

        //Create new Mobile Company with tariffs' list
        MobileCompany company = new MobileCompany("ECell", tariffList);

        // Fill each tariff by clients of mobile company
        for (Map.Entry<Tariff, Integer> tariff : tariffList.entrySet()) {
            int clients = company.getTariffNumberOfClients();
            tariff.setValue(clients);
        }

        logger.info("The list of all tariffs:");
        tariffService.logAllCompanyTariffs(tariffList);

        logger.info("Total customers:");
        logger.info(String.valueOf(company.getLogAllCustomers(tariffList)));
        logger.info("");

        logger.info("Sort tariffs by fee:");
        sortedList = tariffService.SortTariffsByFee(tariffList);
        for (FeeTariff sortList : sortedList)
            logger.info(sortList.toString());
        logger.info("");

        logger.info("Search tariff by range of parameters:");
        int fromMin = 150;
        int toMin = 250;
        int fromMb = 1000;
        int toMb = 2500;
        sortedList = tariffService.findTariffByParams(tariffList, fromMin, toMin, fromMb, toMb);
        for (FeeTariff sortList : sortedList)
            logger.info(sortList.toString());
    }
}
