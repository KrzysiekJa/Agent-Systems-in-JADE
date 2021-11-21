package com.company;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import java.util.Scanner;


public class klasa_6 extends Agent {

    protected void setup() {
        System.out.println("Startuję.");

        addBehaviour(new Behaviour() {
            final Scanner scanner = new Scanner(System.in);
            int num;

            @Override
            public void onStart() {
                super.onStart();
                System.out.println("Zachowanie startuję.");
            }

            public void action() {
                System.out.println("Podaj liczbę: ");
                String str = scanner.nextLine();
                try {
                    num = Integer.parseInt(str);
                } catch (Exception ex){
                    num = 0;
                }
            }

            public boolean done() {
                if(num < 0){
                    System.out.println("Zachowanie zakończone.");
                    doDelete();
                }
                return false;
            }
        });
    }

    protected void takeDown() {
        System.out.println("Zaraz się usunę.");
    }
}
