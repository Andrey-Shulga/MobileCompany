package com.epam.as.mobilecomp.tariffs;

import com.epam.as.mobilecomp.tariffs.fee.FeeTariffs;
import com.epam.as.mobilecomp.tariffs.withoutfee.RegionalTariffs;
import com.epam.as.mobilecomp.tariffs.withoutfee.WithoutFeeTariffs;

import java.util.ArrayList;
import java.util.List;

/**
 * This program demonstrates actions with tariffs of Mobile Company.
 *
 * @author Andrey Shulga
 * @version 1.0 2016-10-06
 */

public class TariffsRunner {
    public static void main(String[] args) {

        //Create list of all tariffs
        List<Tariffs> tariffsList = new ArrayList<>();

        //Add new tariffs with fee in list.
        tariffsList.add(new FeeTariffs("Package all for 1500!", 400000, true, 1500, 250, 1500));
        tariffsList.add(new FeeTariffs("Package all for 500!", 500000, true, 500, 100, 500));
        tariffsList.add(new FeeTariffs("Package all for 3000!", 100000, true, 3000, 350, 2500));
        tariffsList.add(new FeeTariffs("Package all for 2000!", 350000, true, 2000, 250, 1500));
        tariffsList.add(new FeeTariffs("Package all for 2500!", 300000, true, 2500, 300, 2000));
        tariffsList.add(new FeeTariffs("Package all for 1000!", 450000, true, 1000, 200, 1000));

        //Add new general tariffs without fee in list.
        tariffsList.add(new WithoutFeeTariffs("All directions for 10!", 650000, false, 10, 10, 2));
        tariffsList.add(new WithoutFeeTariffs("Cheap calls in-net for 3!", 750000, false, 3, 15, 2));

        //Add new regional tariffs without fee in list.
        tariffsList.add(new RegionalTariffs("North Capital", 1100000, false, "Astana", 3, 7, 1));
        tariffsList.add(new RegionalTariffs("South Capital", 1300000, false, "Almaty", 2, 6, 1));
        tariffsList.add(new RegionalTariffs("Mine Capital", 500000, false, "Karaganda", 2, 4, 1));
        tariffsList.add(new RegionalTariffs("Oil Capital", 600000, false, "Aktau", 3, 6, 1));

    }
}
