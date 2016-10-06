package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.tariffs.Tariffs;

import java.util.List;

/**
 * Actions with tariffs.
 */
public class TariffActions {
    private List<Tariffs> list;

    public static void printTariffsToConsole(List<Tariffs> list) {
        for (Tariffs l : list)
            System.out.println(l.getDescription());
    }

    public static void calculateAllCustomers(List<Tariffs> list) {
        int count = 0;
        for (Tariffs l : list)
            count += l.getCustomers();
        System.out.println(count);
    }

    /** public SortedSet<Tariffs> sortedSet=new SortedSet<>
     (new Comparator<Tariffs>()
     {
     @Override public int compare(Tariffs t1, Tariffs t2) {

     return 0;
     }

     public int compare(Item a, Item b)
     {
     String descrA = a.getDescription();
     String descrB = b.getDescription();
     return descrA.compareTo(descrB);
     }
     });
     */

}
