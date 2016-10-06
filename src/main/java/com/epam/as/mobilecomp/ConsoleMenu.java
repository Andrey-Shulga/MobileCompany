package com.epam.as.mobilecomp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Console menu for program tests.
 */
public class ConsoleMenu {

    public void consoleMenuBuilder() throws IOException {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int s = Integer.parseInt(reader.readLine());
            switch (s) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3: {
                    System.out.println("Exit");
                    System.exit(0);
                }
            }
        }
    }
}
