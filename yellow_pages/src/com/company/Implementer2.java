package com.company;

import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;


public class Implementer2 extends Agent {

    protected void setup() {
        String serviceName = "POWER_2";
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
    }

    protected void takeDown() {
        try{
            DFService.deregister(this);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
    }
}
