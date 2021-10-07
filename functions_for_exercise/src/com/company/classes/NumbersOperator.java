package com.company.classes;

import java.util.Scanner;

public class NumbersOperator {

    private int get_input(){
        System.out.println("Input number:");
        Scanner scanner = new Scanner(System.in);
        int number;
        try {
            number = Integer.parseInt(scanner.nextLine());
            return number;
        } catch (Exception exc) {
            return 0;
        }
    }

    public void checkIfPrime() {
        int number = get_input();

        if (number == 0 || number == 1) {
            System.out.println("0 or 1 are not prime.");
            return;
        }

        for (int i = 2; i < Math.sqrt(number); ++i) {
            if (number % i == 0) {
                System.out.println("Number is not prime.");
                return;
            }
        }

        System.out.println("Is prime number.");
    }

    public void printThePyramid() {
        int number = get_input();

        if (number < 1){
            return;
        }

        for (int i = 0; i < number; ++i){
            String line = " ".repeat(number - i) +
                    "* ".repeat(i);
            System.out.println(line);
        }
    }
}
