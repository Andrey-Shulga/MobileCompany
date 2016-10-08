package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.entities.FeeTariff;
import com.epam.as.mobilecomp.entities.Tariff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

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
        }
    }

    /**
     * Print to  number of customers for all tariff.
     *
     * @param list the list of entities
     */
    public void calculateAllCustomers(ArrayList<Tariff> list) {
        int count = 0;
        for (Tariff l : list)
            //   count += l.getCustomers();
        System.out.println(count);
    }

    /**
     * Print to console list of tariff sorted by fee.
     * For sort uses Comparator.
     *
     * @param list the list of tariff
     */
    public void sortTariffsByFee(ArrayList<Tariff> list) {
        ArrayList<FeeTariff> sortedlist = new ArrayList<FeeTariff>();

        //Add to list entities only with fee.
        for (Tariff selected : list)
            // if (selected.isHasFee()) sortedlist.add((FeeTariff) selected);

        // Sort list uses Comparator
            Collections.sort(sortedlist, new Comparator<FeeTariff>() {
            @Override
            public int compare(FeeTariff t1, FeeTariff t2) {
                return t1.getFee() - t2.getFee();
            }
        });
        for (FeeTariff sort : sortedlist)
            System.out.println(sort);
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
