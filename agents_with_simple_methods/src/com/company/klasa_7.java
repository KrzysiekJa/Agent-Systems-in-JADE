package com.company;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;


public class klasa_7 extends Agent {

    protected void setup() {
        System.out.println("Startuję.");

        addBehaviour(new Behaviour() {
            @Override
            public void action() {
                System.out.println("Pierwsze.");
            }

            @Override
            public boolean done() {
                return true;
            }
        });

        addBehaviour(new Behaviour() {
            int step = 0;

            @Override
            public void onStart() {
                super.onStart();
                System.out.println("Drugie.");
            }

            @Override
            public void action() {
                switch (step) {
                    case 0 -> {
                        System.out.println("Pierwszy krok.");
                        step++;
                    }
                    case 1 -> {
                        System.out.println("Drugi krok.");
                        step++;
                    }
                    case 2 -> {
                        System.out.println("Trzeci krok.");
                        step++;
                    }
                    case 3 -> doDelete();
                }
            }

            @Override
            public boolean done() { return step == 4; }
        });
    }

    protected void takeDown() {
        System.out.println("Zaraz się usunę.");
    }
}
