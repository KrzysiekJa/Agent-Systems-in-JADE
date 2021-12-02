package com.company;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

import java.util.Objects;


public class Implementer extends Agent {

    protected void setup() {
        String serviceName = "POWER";
        String serviceType = "power-shop";

        Object[] args = getArguments();
        if (args != null && args.length > 0) {
            serviceName = (String) args[0];
        }

        System.out.println("Agent "+getLocalName()+" registering service \""+serviceName+"\"");
        try {
            DFAgentDescription dfd = new DFAgentDescription();
            dfd.setName(getAID());
            ServiceDescription sd = new ServiceDescription();
            sd.setName(serviceName);
            sd.setType(serviceType);

            dfd.addServices(sd);
            DFService.register(this, dfd);
        }
        catch (FIPAException fe) {
            fe.printStackTrace();
        }

        addBehaviour(new CyclicBehaviour(this) {
            public void action() {
                ACLMessage msg = myAgent.receive();

                if (msg != null) {
                    ACLMessage reply = msg.createReply();
                    reply.addReceiver(msg.getSender());

                    if (Objects.equals(msg.getPerformative(), ACLMessage.REQUEST)) {
                        int number = Integer.parseInt(msg.getContent());
                        int result = number * number;
                        reply.setPerformative(ACLMessage.INFORM);
                        reply.setContent(Integer.toString(result));
                    }else {
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

    protected void takeDown() {
        try{
            DFService.deregister(this);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
    }
}
