package atmmachine.statepattern;

public class ConcreteTransactionState implements ATMState{
    @Override
    public String getState() {
        return "";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        return null;
    }
}
