package vendingmachine.states;

import vendingmachine.Coin;
import vendingmachine.VendingMachine;

public class DispenseState extends State {


    protected DispenseState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Already received full amount.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispense() {
        //Already trigered by HasMoneyState
    }

    @Override
    public void refund() {
        System.out.println("Dispensing is in progress. Refund not allowed");
    }
}
