package com.company.classes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HundredNumbersGenerator {

    public void findDivisibleBy_3_5() {
        int range = 101;
        String[] numbersArray = new String[range];

        for(int i = 0; i < range; i++){
            if((i%3) == 0){
                if((i%5) == 0){
                    numbersArray[i] = "xyxy";
                }
                else{
                    numbersArray[i] = "xxx";
                }
            } else if((i%5) == 0){
                numbersArray[i] = "yyy";
            } else {
                numbersArray[i] = Integer.toString(i);
            }
        }

        for(String num: numbersArray){
            System.out.println(num);
        }
    }

    public void guessNumber() {
        Random generator = new Random();
        int margin = 101;
        int numberToGuess = generator.nextInt(margin);

        boolean notGuessed = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose numbers: ");

        while(notGuessed){
            String chosenNumber = scanner.nextLine();

            try{
                if (Integer.parseInt(chosenNumber) == numberToGuess) {
                    notGuessed = false;
                    System.out.println("Found!");
                }
            } catch (Exception exception){
                System.out.println("Wrong input.");
            }
        }

    }

    public void elevenNumsTableOperation() {
        int length = 11;
        int[] randomTab = new int[length];
        Random generator = new Random();

        for (int i = 0; i < randomTab.length - 1; ++i) {
            randomTab[i] = generator.nextInt();
        }

        System.out.println(Arrays.toString(randomTab));
        Arrays.sort(randomTab);
        System.out.println("Highest value: " + randomTab[length-1] + ", second: " + randomTab[length-2]);
    }
}
