package atmmachine.statepattern;

public class ConcreteHasCardState implements ATMState{
    @Override
    public String getState() {
        return "";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getCurrentCard() == null) {
            return context.getAtmStateFactory().createIdleState();
        }

        if(context.getCurrentCard() != null) {
            return context.getAtmStateFactory().createSelectOperationState();
        }
        return this;
    }
}
