package com.company.classes;

import java.util.Scanner;

public class CalculateMiles {

    private float get_input(){
        System.out.println("Number of kilometers:");
        Scanner scanner = new Scanner(System.in);
        float number;
        try {
            number = Float.parseFloat(scanner.nextLine());
            return number;
        } catch (Exception exc) {
            return 0;
        }
    }

    public void changeToMiles() {
        float kilometers = get_input();

        float miles = (float) (kilometers * 0.621371);
        float marineMiles = (float) (kilometers * 0.539957);

        System.out.println("Miles: " + miles + ", Marine miles: " + marineMiles);
    }
}
