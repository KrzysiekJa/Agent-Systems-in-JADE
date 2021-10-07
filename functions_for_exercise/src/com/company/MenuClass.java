package com.company;

import com.company.classes.CalculateMiles;
import com.company.classes.HundredNumbersGenerator;
import com.company.classes.NumbersOperator;
import com.company.classes.WordsManipulator;

import java.util.Scanner;

class MenuClass {

    void run(){
        Scanner scanner = new Scanner(System.in);
        boolean isEnd = true;

        HundredNumbersGenerator generator = new HundredNumbersGenerator();
        WordsManipulator wordsManipulator = new WordsManipulator();
        NumbersOperator numbersOperator = new NumbersOperator();
        CalculateMiles calculateMiles = new CalculateMiles();

        do {
            System.out.println("Choose number: ");

            switch (scanner.nextLine()) {
                case "0" -> generator.findDivisibleBy_3_5();
                case "1" -> generator.guessNumber();
                case "2" -> generator.elevenNumsTableOperation();
                case "3" -> wordsManipulator.checkIfPalindrome();
                case "4" -> wordsManipulator.countWordsInSentence();
                case "5" -> numbersOperator.checkIfPrime();
                case "6" -> numbersOperator.printThePyramid();
                case "7" -> calculateMiles.changeToMiles();
                default -> isEnd = false;
            }
        }while(isEnd);
    }
}
