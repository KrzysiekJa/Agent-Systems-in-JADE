package com.company.classes;

import java.util.Scanner;

public class Calculator {
    private final Scanner scanner = new Scanner(System.in);
    private Integer firstNum, secondNum;
    private int thirdNum;

    public void run() {
        get_numbers();
        System.out.println(show_output(firstNum, secondNum, thirdNum));
    }

    private void get_numbers(){
        System.out.println("First input number: ");
        this.firstNum = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Second input number: ");
        this.secondNum = Integer.parseInt(this.scanner.nextLine());
        System.out.println("Third input number: ");
        this.thirdNum = Integer.parseInt(this.scanner.nextLine());
    }

    private String show_output(int a, int b, int c){
        if ((a + b) * c > 100){
            return "Bigger than 100.";
        } else {
            return "Smaller than 100.";
        }
    }
}
