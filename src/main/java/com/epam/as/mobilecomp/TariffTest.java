package com.epam.as.mobilecomp;

import com.epam.as.mobilecomp.entities.FeeTariff;
import com.epam.as.mobilecomp.entities.Tariff;
import com.epam.as.mobilecomp.entities.WithoutFeeTariff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * This program demonstrates actions with entities of Mobile Company.
 *
 * @author Andrey Shulga
 * @version 1.0 2016-10-06
 */

public class TariffTest {

    public static void main(String[] args) throws IOException {

        boolean flag = true;
        TariffService tariffService = new TariffService();
        ArrayList<Tariff> tariffsList = new ArrayList<>();

        //Add new entities with fee in list.
        tariffsList.add(new FeeTariff("All for 1500!", 1500, 150, 1500));
        tariffsList.add(new FeeTariff("All for 500!", 500, 50, 500));
        tariffsList.add(new FeeTariff("All for 3000!", 3000, 300, 2500));
        tariffsList.add(new FeeTariff("All for 2000!", 2000, 200, 1500));
        tariffsList.add(new FeeTariff("All for 2500!", 2500, 250, 2000));
        tariffsList.add(new FeeTariff("All for 1000!", 1000, 100, 1000));

        //Add new general entities without fee in list.
        tariffsList.add(new WithoutFeeTariff("All directions for 10!", 10, 10, 1));
        tariffsList.add(new WithoutFeeTariff("Cheap calls in-net for 3!", 3, 15, 1));

        //Console Menu with actions.
        while (flag) {
            System.out.println("Menu. Please enter number of menu item...");
            System.out.println("1. Show all entities's plans");
            System.out.println("2. Show all customers");
            System.out.println("3. Sort entities by subscription fee.");
            System.out.println("4. Search entities by parameters");
            System.out.println("5. Exit");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int s = Integer.parseInt(reader.readLine());
            if (s >= 1 && s <= 5) {
                switch (s) {
                    case 1:
                        System.out.println("The list of all entities:");
                        tariffService.printTariffsToConsole(tariffsList);
                        System.out.println();
                        break;
                    case 2:
                        System.out.print("Number of all customers: ");
                        tariffService.calculateAllCustomers(tariffsList);
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Sort entities by fee: ");
                        tariffService.sortTariffsByFee(tariffsList);
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("Find entities by parameters' range: minutes 200-450, mbytes 1000-2500 ");
                        int fromMin = 200;
                        int toMin = 450;
                        int fromMbs = 1000;
                        int toMbs = 2500;
                        tariffService.findTariffByParams(tariffsList, fromMin, toMin, fromMbs, toMbs);
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
