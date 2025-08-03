package vendingmachine.states;

import vendingmachine.Coin;
import vendingmachine.VendingMachine;

public class ItemSelectedState extends State {


    protected ItemSelectedState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin(Coin coin) {

        vendingMachine.addBalance(coin.getValue());
        System.out.println("Coin inserted: " + coin.getValue());
        int price = vendingMachine.getSelectedItem().getPrice();
        if(vendingMachine.getBalance() >= price) {
            System.out.println("Sufficient money received.");
            vendingMachine.setState(new HasMoneyState(vendingMachine));
        }

    }

    @Override
    public void selectItem(String code) {
        //Validate code and set next code
        System.out.println("Item code selected: " + code);
        //Set next state
    }

    @Override
    public void dispense() {

    }

    @Override
    public void refund() {

    }


}
