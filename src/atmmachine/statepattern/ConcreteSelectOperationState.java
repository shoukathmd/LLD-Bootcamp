package atmmachine.statepattern;

public class ConcreteSelectOperationState implements ATMState{
    @Override
    public String getState() {
        return "";
    }

    @Override
    public ATMState next(ATMMachineContext context) {

        if(context.getCurrentState() == null || context.getCurrentCard() == null) {
            return context.getAtmStateFactory().createIdleState();
        }

        if(context.getSelectedOperation() != null) {
            return context.getAtmStateFactory().createTransactionState();
        }
        return this;
    }
}
