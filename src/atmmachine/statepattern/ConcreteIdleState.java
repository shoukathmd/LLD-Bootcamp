package atmmachine.statepattern;

public class ConcreteIdleState implements ATMState{

    public ConcreteIdleState() {
        System.out.println("ATM initialised in Idle State - Please insert your card");
    }
    @Override
    public String getState() {
        return "IdleState";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getCurrentCard() != null) {
            return context.getAtmStateFactory().createHasCardState();
        }
        return this;
    }
}
