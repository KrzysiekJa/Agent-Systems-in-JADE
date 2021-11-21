package com.company;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;


public class klasa_2 extends Agent {
    protected void setup() {

        System.out.println("Startuję.");

        addBehaviour(new OneShotBehaviour( this ) {
            public void action()
            {
                System.out.println( "Wykonuję.");
                doDelete();
            }
        });
    }
    protected void takeDown() {
        System.out.println("Zaraz się usunę.");
    }
}
