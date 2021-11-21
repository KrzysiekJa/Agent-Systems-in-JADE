package com.company;

import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class klasa_2_1 extends Agent {

    @Override
    protected void setup() {
        FSMBehaviour fsmBehaviour = new FSMBehaviour(this){

            @Override
            public int onEnd() {
                System.out.println("Behaviour complited.");
                myAgent.doDelete();
                return super.onEnd();
            }
        };

        fsmBehaviour.registerFirstState(new OneShotBehaviour(this) {
            @Override
            public void action() {
                System.out.println("State A");
            }
        }, "A");

        fsmBehaviour.registerLastState(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("State E");
            }
        }, "E");

        fsmBehaviour.registerState(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("State B");
            }

            @Override
            public int onEnd() {
                int var = (int) Math.round( Math.random() );
                System.out.println(var);
                return var;
            }
        }, "B");

        fsmBehaviour.registerState(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("State C");
            }
        }, "C");

        fsmBehaviour.registerState(new OneShotBehaviour() {
            @Override
            public void action() {
                System.out.println("State D");
            }

            @Override
            public int onEnd() {
                int var = (int) Math.round( Math.random() );
                System.out.println(var);
                return var;
            }
        }, "D");

        fsmBehaviour.registerDefaultTransition("A", "B");
        fsmBehaviour.registerDefaultTransition("C", "D");
        fsmBehaviour.registerTransition("B", "C", 1);
        fsmBehaviour.registerTransition("B", "D", 0);
        fsmBehaviour.registerTransition("D", "A", 1);
        fsmBehaviour.registerTransition("D", "E", 0);
        addBehaviour(fsmBehaviour);
    }
}
