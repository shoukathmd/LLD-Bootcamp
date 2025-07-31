package atmmachine.statepattern;

public interface ATMState {


    public String getState();

    public ATMState next(ATMMachineContext context);
}
