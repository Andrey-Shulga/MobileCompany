package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.tariffs.Tariffs;
import com.epam.as.mobilecomp.tariffs.fee.FeeTariffs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Actions with tariffs.
 */
public class TariffActions {

    /**
     * Print to console all tariffs.
     *
     * @param list the list of tariffs
     */
    public void printTariffsToConsole(List<Tariffs> list) {
        for (Tariffs l : list)
            System.out.println(l.getDescription());
    }

    /**
     * Print to console number of customers for all tariffs.
     *
     * @param list the list of tariffs
     */
    public void calculateAllCustomers(List<Tariffs> list) {
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
        ;
    }

}
