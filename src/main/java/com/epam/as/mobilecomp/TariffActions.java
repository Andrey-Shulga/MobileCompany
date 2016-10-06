package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.tariffs.Tariffs;
import com.epam.as.mobilecomp.tariffs.fee.FeeTariffs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Actions with tariffs.
 */
public class TariffActions {

    /**
     * Print to console all tariffs.
     *
     * @param list the list of tariffs
     */
    public void printTariffsToConsole(ArrayList<Tariffs> list) {
        for (Tariffs l : list)
            System.out.println(l.getDescription());
    }

    /**
     * Print to console number of customers for all tariffs.
     *
     * @param list the list of tariffs
     */
    public void calculateAllCustomers(ArrayList<Tariffs> list) {
        int count = 0;
        for (Tariffs l : list)
            count += l.getCustomers();
        System.out.println(count);
    }

    /**
     * Print to console list of tariffs sorted by fee.
     * For sort uses Comparator.
     *
     * @param list the list of tariffs
     */
    public void sortTariffsByFee(ArrayList<Tariffs> list) {
        ArrayList<FeeTariffs> sortedlist = new ArrayList<FeeTariffs>();

        //Add to list tariffs only with fee.
        for (Tariffs selected : list)
            if (selected.isHasFee()) sortedlist.add((FeeTariffs) selected);

        // Sort list uses Comparator
        Collections.sort(sortedlist, new Comparator<FeeTariffs>() {
            @Override
            public int compare(FeeTariffs t1, FeeTariffs t2) {
                return t1.getFee() - t2.getFee();
            }
        });
        for (FeeTariffs sort : sortedlist)
            System.out.println(sort);
    }

    /**
     * Search tariff by parameters' range.
     *
     * @param list    the list of tariffs
     * @param fromMin initial parameter for search minutes
     * @param toMin   finial parameter for search minutes
     * @param fromMbs initial parameter for search megabytes
     * @param toMbs   finial parameter for search megabytes
     */
    public void findTariffByParams(ArrayList<Tariffs> list, int fromMin, int toMin, int fromMbs, int toMbs) {
        ArrayList<FeeTariffs> sortedlist = new ArrayList<FeeTariffs>();

        //Add to list tariffs only with fee.
        for (Tariffs selected : list)
            if (selected.isHasFee()) sortedlist.add((FeeTariffs) selected);
        for (FeeTariffs select : sortedlist) {
            if ((select.getIncludeMinutes() >= fromMin) && (select.getIncludeMinutes() <= toMin))
                if ((select.getIncludeTraffic() >= fromMbs) && (select.getIncludeTraffic() <= toMbs))
                    System.out.println(select.getDescription());
        }
    }

}
