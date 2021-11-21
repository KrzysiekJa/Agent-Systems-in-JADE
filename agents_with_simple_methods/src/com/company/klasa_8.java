package com.company;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;


public class klasa_8 extends Agent {

    protected void setup() {
        System.out.println("Startuję.");

        addBehaviour(new TickerBehaviour(this, 2000) {
            @Override
            protected void onTick() {
                System.out.println("Mały tick.");
            }
        });

        addBehaviour(new TickerBehaviour(this, 5000) {
            final int timeStep = 1000;
            final int finingTime = 50;

            @Override
            protected void onTick() {
                if (getPeriod() == timeStep * finingTime){
                    stop();
                }
                System.out.println("Duży tick.");
            }


        });

        addBehaviour(new WakerBehaviour(this, 100000) {

            @Override
            protected void onWake() {
                super.onWake();
                doDelete();
            }
        });
    }
    protected void takeDown() {
        System.out.println("Zaraz się usunę.");
    }
}
