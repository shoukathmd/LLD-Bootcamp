package vendingmachine;

public class VendingMachineDemo {

    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        vendingMachine.addItem("A1", "Coke", 25, 3);
        vendingMachine.addItem("A2", "Pepsi", 25, 2);
        vendingMachine.addItem("B1", "Water", 10, 5);

        System.out.println("\n Step 1: Select an item ---");
        vendingMachine.selectItem("A1");

        //Insert coins
        System.out.println("\n --- Step 2: Insert coins ---");
        vendingMachine.insertCoin(Coin.DIME);
        vendingMachine.insertCoin(Coin.DIME);
        vendingMachine.insertCoin(Coin.NICKEL);

        // Dispense Product
        System.out.println("\n --- Step3: Dispense item ---");
        vendingMachine.dispense(); //Should deipense code

        System.out.println("\n --- Step 4: Select another item ---");
        vendingMachine.selectItem("B1");

        // Insert more amount
        System.out.println("\n --- Step 5:Insert more than needed");
        vendingMachine.insertCoin(Coin.QUARTER); //25

        System.out.println("\n --- Step 6: Dispense and return change ---");
        vendingMachine.dispense();


    }
}
