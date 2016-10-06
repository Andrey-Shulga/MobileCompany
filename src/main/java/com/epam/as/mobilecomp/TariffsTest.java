package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.tariffs.Tariffs;
import com.epam.as.mobilecomp.tariffs.fee.FeeTariffs;
import com.epam.as.mobilecomp.tariffs.withoutfee.RegionalTariffs;
import com.epam.as.mobilecomp.tariffs.withoutfee.WithoutFeeTariffs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * This program demonstrates actions with tariffs of Mobile Company.
 *
 * @author Andrey Shulga
 * @version 1.0 2016-10-06
 */

public class TariffsTest {

    public static void main(String[] args) throws IOException {

        boolean flag = true;
        TariffActions tariffActions = new TariffActions();
        ArrayList<Tariffs> tariffsList = new ArrayList<>();

        //Add new tariffs with fee in list.
        tariffsList.add(new FeeTariffs("All for 1500!", 400000, true, 1500, 150, 1500));
        tariffsList.add(new FeeTariffs("All for 500!", 500000, true, 500, 50, 500));
        tariffsList.add(new FeeTariffs("All for 3000!", 100000, true, 3000, 300, 2500));
        tariffsList.add(new FeeTariffs("All for 2000!", 350000, true, 2000, 200, 1500));
        tariffsList.add(new FeeTariffs("All for 2500!", 300000, true, 2500, 250, 2000));
        tariffsList.add(new FeeTariffs("All for 1000!", 450000, true, 1000, 100, 1000));

        //Add new general tariffs without fee in list.
        tariffsList.add(new WithoutFeeTariffs("All directions for 10!", 650000, false, 10, 10, 1));
        tariffsList.add(new WithoutFeeTariffs("Cheap calls in-net for 3!", 750000, false, 3, 15, 1));

        //Add new regional tariffs without fee in list.
        tariffsList.add(new RegionalTariffs("North Capital", 1100000, false, "Astana", 3, 7, 1));
        tariffsList.add(new RegionalTariffs("South Capital", 1350000, false, "Almaty", 2, 6, 1));
        tariffsList.add(new RegionalTariffs("Mine Capital", 500000, false, "Karaganda", 2, 4, 1));
        tariffsList.add(new RegionalTariffs("Oil Capital", 600000, false, "Aktau", 3, 6, 1));

        //Console Menu with actions.
        while (flag) {
            System.out.println("Menu. Please enter number of menu item...");
            System.out.println("1. Show all tariff's plans");
            System.out.println("2. Show all customers");
            System.out.println("3. Sort tariffs by subscription fee.");
            System.out.println("4. Search tariff by parameters");
            System.out.println("5. Exit");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int s = Integer.parseInt(reader.readLine());
            if (s >= 1 && s <= 5) {
                switch (s) {
                    case 1:
                        System.out.println("The list of all tariffs:");
                        tariffActions.printTariffsToConsole(tariffsList);
                        System.out.println();
                        break;
                    case 2:
                        System.out.print("Number of all customers: ");
                        tariffActions.calculateAllCustomers(tariffsList);
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Sort tariffs by fee: ");
                        tariffActions.sortTariffsByFee(tariffsList);
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("Find tariff by parameters' range: minutes 200-450, mbytes 1000-2500 ");
                        int fromMin = 200;
                        int toMin = 450;
                        int fromMbs = 1000;
                        int toMbs = 2500;
                        tariffActions.findTariffByParams(tariffsList, fromMin, toMin, fromMbs, toMbs);
                        System.out.println();
                        break;
                    case 5:
                        System.out.println("Exit");
                        System.exit(0);
                }
            } else System.out.println("You entered wrong number, please try again.");
        }
    }
}
