package com.company;

import jade.core.Agent;


public class klasa_1 extends Agent {

    protected void setup() {
        System.out.println("Startuję.");
        doDelete();
    }
    protected void takeDown() {
        System.out.println("Zaraz się usunę.");
    }
}
