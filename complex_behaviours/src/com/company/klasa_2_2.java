package com.company;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.ParallelBehaviour;

public class klasa_2_2 extends Agent {

    protected void setup() {
        ParallelBehaviour parallelBehaviour = new ParallelBehaviour(this, ParallelBehaviour.WHEN_ANY);


        parallelBehaviour.addSubBehaviour(new Behaviour() {
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
            public boolean done() { return step == 4; }
        });

        parallelBehaviour.addSubBehaviour(new Behaviour() {
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
            public boolean done() { return step == 4; }
        });

        parallelBehaviour.addSubBehaviour(new Behaviour() {
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
            public boolean done() { return step == 4; }
        });


        addBehaviour(parallelBehaviour);
    }

    protected void takeDown() {
        System.out.println("Finishing.");
    }
}
