package vendingmachine.states;

import vendingmachine.Coin;
import vendingmachine.VendingMachine;

public class HasMoneyState extends State {
    protected HasMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Coin inserted : " + coin);
        // set next state
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected");
    }

    @Override
    public void dispense() {
        vendingMachine.setState(new DispenseState(vendingMachine));
        vendingMachine.dispenseItem();
    }

    @Override
    public void refund() {
        vendingMachine.refundBalance();
        vendingMachine.reset();
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
