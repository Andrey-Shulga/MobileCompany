package com.epam.as.mobilecomp.service;

import com.epam.as.mobilecomp.entities.FeeTariff;
import com.epam.as.mobilecomp.entities.Tariff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Actions with tariffs.
 */
public class TariffService {

    Logger logger = LoggerFactory.getLogger(TariffService.class);

    /**
     * Print to console all tariff.
     *
     * @param tariffMap the list of tariff
     */
    public void logAllCompanyTariffs(Map<Tariff, Integer> tariffMap) {

        for (Map.Entry m : tariffMap.entrySet()) {
            logger.info(m.getKey().toString());
            logger.info("Customers:" + m.getValue().toString());
        }
        logger.info("");
    }

    /**
     * Print list of tariff sorted by fee.
     * For sort uses sorted collection TreeSet.
     *
     * @param tariffMap the list of tariff
     * @return the list of tariffs sorted by monthly fee
     */
    public Set<FeeTariff> SortTariffsByFee(Map<Tariff, Integer> tariffMap) {
        Set<FeeTariff> sortedlist = new TreeSet<>();

        //Add to list tariff only with fee.
        for (Map.Entry m : tariffMap.entrySet())
            if (m.getKey() instanceof FeeTariff)
                sortedlist.add((FeeTariff) m.getKey());

        return sortedlist;
    }

    /**
     * Search tariffs by parameters' range and print them.
     *
     * @param tariffMap    the list of tariff
     * @param fromMin initial parameter for search minutes
     * @param toMin   finial parameter for search minutes
     * @param fromMbs initial parameter for search megabytes
     * @param toMbs   finial parameter for search megabytes
     * @return the list of tariffs selected by parameters
     */
    public Set<FeeTariff> findTariffByParams(Map<Tariff, Integer> tariffMap, int fromMin, int toMin, int fromMbs, int toMbs) {
        Set<FeeTariff> tariffList = new TreeSet<>();
        Set<FeeTariff> selectedlist = new TreeSet<>();

        //Add to list tariff only with fee.
        for (Map.Entry m : tariffMap.entrySet())
            if (m.getKey() instanceof FeeTariff)
                tariffList.add((FeeTariff) m.getKey());

        for (FeeTariff select : tariffList) {
                if ((select.getIncludedMinutes() >= fromMin) && (select.getIncludedMinutes() <= toMin))
                    if ((select.getIncludedTraffic() >= fromMbs) && (select.getIncludedTraffic() <= toMbs))
                        selectedlist.add(select);

        }
        return selectedlist;
    }

}
