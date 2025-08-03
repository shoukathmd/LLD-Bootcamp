package vendingmachine.states;

import vendingmachine.Coin;
import vendingmachine.VendingMachine;

public class IdleState extends State {


    public IdleState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please select an item before inserting coin");
    }

    @Override
    public void selectItem(String code) {
        if(!vendingMachine.getInventory().isAvailable(code)) {
            System.out.println("Item not available");
            return;
        }
        vendingMachine.setSelectedItemCode(code);
        vendingMachine.setState(new ItemSelectedState(vendingMachine));
        System.out.println("Item selected: " + code);
    }

    @Override
    public void dispense() {
        System.out.println("Item not selected");
    }

    @Override
    public void refund() {
        System.out.println("No money to refund");
    }
}
