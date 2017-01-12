package unsa.agente_tais.agents;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import unsa.agente_tais.app.Register;

public class AgenteInterfaz extends GuiAgent {

    @Override
    protected void onGuiEvent(GuiEvent ge) {
        String rpt = ge.getParameter(1).toString();
        ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
        msg.addReceiver(new AID("experto@tais", AID.ISLOCALNAME));
        msg.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
        msg.setContent(rpt);
        addBehaviour(new ManejadorInitiator(this, msg));
    }

    @Override
    protected void setup() {
        Register gui = new Register(this);
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
    }

    class ManejadorInitiator extends AchieveREInitiator {

        public ManejadorInitiator(Agent a, ACLMessage msg) {
            super(a, msg);
        }

        @Override
        protected void handleAgree(ACLMessage agree) {
            System.out.println("Hospital " + agree.getSender().getName()
                    + " informa que han salido a atender el accidente.");
        }

        @Override
        protected void handleRefuse(ACLMessage refuse) {
            System.out.println("Hospital " + refuse.getSender().getName()
                    + " responde que el accidente esta fuera de su radio de accion. No llegaremos a tiempo!!!");
        }

        @Override
        protected void handleNotUnderstood(ACLMessage notUnderstood) {
            System.out.println("Hospital " + notUnderstood.getSender().getName()
                    + " no puede entender el mensaje.");
        }

        @Override
        protected void handleInform(ACLMessage inform) {
            System.out.println("Hospital " + inform.getSender().getName()
                    + " informa que han atendido el accidente.");
        }

        @Override
        protected void handleFailure(ACLMessage fallo) {
            if (fallo.getSender().equals(myAgent.getAMS())) {
                System.out.println("Alguna de los hospitales no existe");
            } else {
                System.out.println("Fallo en el hospital " + fallo.getSender().getName()
                        + ": " + fallo.getContent().substring(1, fallo.getContent().length() - 1));
            }
        }
    }
}
