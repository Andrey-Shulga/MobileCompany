package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.entities.FeeTariff;
import com.epam.as.mobilecomp.entities.Tariff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Actions with entities.
 */
public class TariffService {

    /**
     * Print to console all entities.
     *
     * @param list the list of entities
     */
    public void printTariffsToConsole(ArrayList<Tariff> list) {
        for (Tariff l : list)
            System.out.println(l.getDescription());
    }

    /**
     * Print to console number of customers for all entities.
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
     * Print to console list of entities sorted by fee.
     * For sort uses Comparator.
     *
     * @param list the list of entities
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
     * @param list    the list of entities
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
