package com.company;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;

import java.util.Scanner;


public class klasa_5 extends Agent {

    protected void setup() {
        System.out.println("Startuję.");

        addBehaviour(new Behaviour() {
           final Scanner scanner = new Scanner(System.in);
           int num;

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
