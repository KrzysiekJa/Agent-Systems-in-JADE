package com.company;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.SequentialBehaviour;

public class klasa_2_3 extends Agent {

    protected void setup() {
        SequentialBehaviour sequentialBehaviour = new SequentialBehaviour(this);


        sequentialBehaviour.addSubBehaviour(new Behaviour(this) {
            int step = 0;

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
            public boolean done() { return step == 3; }
        });

        sequentialBehaviour.addSubBehaviour(new Behaviour(this) {
            int step = 0;

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
            public boolean done() { return step == 3; }
        });

        sequentialBehaviour.addSubBehaviour(new Behaviour(this) {
            int step = 0;

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
            public boolean done() { return step == 3; }
        });


        addBehaviour(sequentialBehaviour);
    }

    protected void takeDown() {
        System.out.println("Finishing.");
    }
}
