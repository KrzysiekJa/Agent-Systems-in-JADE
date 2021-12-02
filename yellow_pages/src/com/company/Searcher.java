package com.company;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.util.leap.Iterator;


public class Searcher extends Agent {

    protected void setup() {
        String serviceName = "POWER_2";
        String serviceType = "power-shop";

        System.out.println("Agent "+getLocalName()+" searching for services of type "+serviceType);
        try {
            DFAgentDescription template = new DFAgentDescription();
            ServiceDescription templateSd = new ServiceDescription();
            templateSd.setType(serviceType);
            template.addServices(templateSd);

            SearchConstraints sc = new SearchConstraints();
            sc.setMaxResults(new Long(20));

            DFAgentDescription[] results = DFService.search(this, template, sc);

            if (results.length > 0) {
                System.out.println("Agent "+getLocalName()+" found the following "+serviceType+" services:");

                for (int i = 0; i < results.length; ++i) {
                    DFAgentDescription dfd = results[i];
                    AID provider = dfd.getName();

                    Iterator it = dfd.getAllServices();
                    while (it.hasNext()) {
                        ServiceDescription sd = (ServiceDescription) it.next();
                        if (sd.getName().equals(serviceName)) {
                            System.out.println("- Service \""+sd.getName()+"\" provided by agent "+provider.getName());
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
}
