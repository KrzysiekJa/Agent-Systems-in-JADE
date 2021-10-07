package com.company.classes;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class WordsManipulator {

    private String get_input(){
        System.out.println("Write the sentence:");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    public void checkIfPalindrome() {
        String inputString = get_input();
        System.out.println(inputString);

        StringBuilder stringBuilder = new StringBuilder(inputString);
        stringBuilder.reverse();
        System.out.println(stringBuilder);

        if(Objects.equals(inputString, stringBuilder.toString())){
            System.out.println("It's a palindrome.");
        } else {
            System.out.println("It's not a palindrome.");
        }
    }

    public void countWordsInSentence() {
        String sentence = get_input();
        String[] parts = sentence.split(" ");
        HashMap<String, Integer> wordsAmountMap = new HashMap<String, Integer>();

        for(String part: parts){
            if(wordsAmountMap.containsKey(part)){
                wordsAmountMap.put(part, wordsAmountMap.get(part) + 1);
            } else {
                wordsAmountMap.put(part, 1);
            }
        }

        System.out.println(wordsAmountMap);
    }
}
