package com.company;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.util.leap.Iterator;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class Client extends Agent {

    protected void setup() {
        String serviceName = "POWER";
        String serviceType = "power-shop";
        Random random = new Random();
        int low = 0;
        int high = 101;
        int randomNum = random.nextInt(high-low) + low;


        addBehaviour(new TickerBehaviour(this, 20000) {
            @Override
            protected void onTick() {

                System.out.println("Agent "+getLocalName()+" searching for services of type "+serviceType);
                try {
                    DFAgentDescription template = new DFAgentDescription();
                    ServiceDescription templateSd = new ServiceDescription();
                    templateSd.setType(serviceType);
                    template.addServices(templateSd);

                    SearchConstraints sc = new SearchConstraints();
                    sc.setMaxResults(new Long(20));

                    DFAgentDescription[] results = DFService.search(myAgent, template, sc);

                    if (results.length > 0) {

                        for (int i = 0; i < results.length; ++i) {
                            DFAgentDescription dfd = results[i];
                            AID provider = dfd.getName();

                            Iterator it = dfd.getAllServices();
                            while (it.hasNext()) {
                                ServiceDescription sd = (ServiceDescription) it.next();
                                if (sd.getName().equals(serviceName)) {
                                    ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
                                    msg.addReceiver(provider);
                                    msg.setContent(Integer.toString(randomNum));
                                    myAgent.send(msg);

                                    try {
                                        TimeUnit.SECONDS.sleep(1);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    ACLMessage reply = myAgent.receive();

                                    if (Objects.equals(reply.getPerformative(), ACLMessage.INFORM)) {
                                        System.out.println(reply.getContent());
                                        doDelete();
                                    }
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("Agent "+getLocalName()+" did not find any "+serviceType+" service");
                    }
                }
                catch (FIPAException fe) {
                    fe.printStackTrace();
                }
            }
        });
    }
}
