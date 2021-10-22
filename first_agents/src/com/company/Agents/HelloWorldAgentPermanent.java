package com.company.Agents;
import jade.core.Agent;


public class HelloWorldAgentPermanent extends Agent {
    protected void setup() {
        System.out.println("Hello World! My name is " + getLocalName());
    }
}