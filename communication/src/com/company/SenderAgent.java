package com.company;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.Objects;
import java.util.concurrent.TimeUnit;


public class SenderAgent extends Agent {

    protected void setup() {
        addBehaviour(new CyclicBehaviour(this) {
            public void action() {

                int zeroOrOne = (int) Math.round(Math.random());
                ACLMessage request = new ACLMessage(ACLMessage.NOT_UNDERSTOOD);

                if (zeroOrOne == 0) {
                    request = new ACLMessage(ACLMessage.CFP);
                    request.addReceiver(new AID("BOT", AID.ISLOCALNAME));
                    request.setContent("CFP message.");
                } else if (zeroOrOne == 1) {
                    request = new ACLMessage(ACLMessage.REQUEST);
                    request.addReceiver(new AID("BOT", AID.ISLOCALNAME));
                    request.setContent("REQUEST message.");
                }
                myAgent.send(request);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                ACLMessage msg = myAgent.receive();

                if (msg != null) {
                    System.out.println("Received: " + msg.getContent());

                    if (Objects.equals(msg.getPerformative(), ACLMessage.INFORM)) {
                        doDelete();
                    }
                }
            }
        } );
    }
}
