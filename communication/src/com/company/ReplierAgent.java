package com.company;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Objects;


public class ReplierAgent extends Agent {

    protected void setup() {
        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = myAgent.receive();

                if (msg != null) {
                    ACLMessage reply = msg.createReply();
                    reply.addReceiver(msg.getSender());

                    if (Objects.equals(msg.getPerformative(), ACLMessage.REQUEST)) {
                        System.out.println("Received: " + msg.getContent());
                        reply.setPerformative(ACLMessage.INFORM);
                        reply.setContent("Wykonałem.");
                    } else if (Objects.equals(msg.getPerformative(), ACLMessage.CFP)) {
                        System.out.println("Received: " + msg.getContent());
                        reply.setPerformative(ACLMessage.REQUEST);
                        reply.setContent("Raz jeszcze.");
                    }
                    else {
                        reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                        reply.setContent("Unknown-content.");
                    }
                    myAgent.send(reply);
                }
                else {
                    block();
                }
            }
        } );
    }
}
