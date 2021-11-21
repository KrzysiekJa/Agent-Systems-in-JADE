package com.company;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;


public class klasa_3 extends Agent {

    protected void setup() {
        System.out.println("Startuję.");

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                System.out.println( "Wykonuję.");
            }
        });

        addBehaviour(new Behaviour() {
            int step = 0;

            @Override
            public void action() {
                switch (step) {
                    case 0, 1, 2 -> {
                        System.out.println(step);
                        step++;
                    }
                    case 3 -> doDelete();
                }
            }

            @Override
            public boolean done() { return step == 4; }
        });
    }

    protected void takeDown() { System.out.println("Zaraz się usunę."); }
}
