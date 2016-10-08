package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.entities.FeeTariff;
import com.epam.as.mobilecomp.entities.Tariff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Actions with tariffs.
 */
public class TariffService {

    Logger logger = LoggerFactory.getLogger("com.epam.as.mobilecomp.TariffService");

    /**
     * Print to console all tariff.
     *
     * @param tariffMap the list of tariff
     */
    public void printTariffsToConsole(Map<Tariff, Integer> tariffMap) {
        logger.info("The list of all tariffs:");
        for (Map.Entry m : tariffMap.entrySet()) {
            logger.info(m.getKey().toString());
            logger.info("Customers:" + m.getValue().toString());
        }
        logger.info("");
    }

    /**
     * Print to  number of customers for all tariff.
     *
     * @param tariffMap the list of entities
     */
    public void calculateAllCustomers(Map<Tariff, Integer> tariffMap) {
        int count = 0;
        logger.info("Total customers:");
        for (Map.Entry m : tariffMap.entrySet())
            count += Integer.parseInt(m.getValue().toString());
        logger.info(String.valueOf(count));
        logger.info("");
    }

    /**
     * Print to console list of tariff sorted by fee.
     * For sort uses Comparator.
     *
     * @param tariffMap the list of tariff
     */
    public void sortTariffsByFee(Map<Tariff, Integer> tariffMap) {
        Set<FeeTariff> sortedlist = new TreeSet<>();
        logger.info("Sort tariffs by fee:");

        //Add to list entities only with fee.
        for (Map.Entry m : tariffMap.entrySet())
            if (m.getKey() instanceof FeeTariff)
                sortedlist.add((FeeTariff) m.getKey());

        for (FeeTariff sort : sortedlist)
            logger.info(sort.toString());
        logger.info("");
    }

    /**
     * Search entities by parameters' range.
     *
     * @param list    the list of tariff
     * @param fromMin initial parameter for search minutes
     * @param toMin   finial parameter for search minutes
     * @param fromMbs initial parameter for search megabytes
     * @param toMbs   finial parameter for search megabytes
     */
    public void findTariffByParams(ArrayList<Tariff> list, int fromMin, int toMin, int fromMbs, int toMbs) {
        ArrayList<FeeTariff> sortedlist = new ArrayList<FeeTariff>();

        //Add to list entities only with fee.
        for (Tariff selected : list)
            //  if (selected.isHasFee()) sortedlist.add((FeeTariff) selected);
            for (FeeTariff select : sortedlist) {
                if ((select.getIncludedMinutes() >= fromMin) && (select.getIncludedMinutes() <= toMin))
                    if ((select.getIncludedTraffic() >= fromMbs) && (select.getIncludedTraffic() <= toMbs))
                    System.out.println(select.getDescription());
        }
    }

}
