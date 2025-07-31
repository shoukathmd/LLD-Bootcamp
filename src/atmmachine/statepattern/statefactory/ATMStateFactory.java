package atmmachine.statepattern.statefactory;

import atmmachine.statepattern.*;

public class ATMStateFactory {


    private static ATMStateFactory insttance;


    private ATMStateFactory() {}


    public static ATMStateFactory getInstance() {
        if (insttance == null) {
            insttance = new ATMStateFactory();
        }
        return  insttance;
    }

    public ATMState createIdleState() {
        return (ATMState) new ConcreteIdleState();
    }

    public ATMState createHasCardState() {
        return (ATMState) new ConcreteHasCardState();
    }

    public ATMState createSelectOperationState() {
        return (ATMState) new ConcreteSelectOperationState();
    }

    public ATMState createTransactionState() {
        return (ATMState) new ConcreteTransactionState();
    }
}
