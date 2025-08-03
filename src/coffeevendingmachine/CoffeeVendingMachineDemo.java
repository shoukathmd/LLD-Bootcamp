package coffeevendingmachine;

public class CoffeeVendingMachineDemo {

    public static void main(String[] args) {
        CoffeeVendingMachine coffeeVendingMachine = CoffeeVendingMachine.getInstance();

        coffeeVendingMachine.refillIngredient("Water", 120);
        coffeeVendingMachine.refillIngredient("Milk", 70);
        coffeeVendingMachine.refillIngredient("Coffee", 150);

        //Display coffee menu
        coffeeVendingMachine.displayMenu();

        CoffeeRecipe espresso = coffeeVendingMachine.selectCoffee("Espresso");
        coffeeVendingMachine.dispenseCoffee(espresso, new Payment(3.0));

        CoffeeRecipe cappuccino = coffeeVendingMachine.selectCoffee("Cappuccino");
        coffeeVendingMachine.dispenseCoffee(cappuccino, new Payment(3.5));

        CoffeeRecipe latte = coffeeVendingMachine.selectCoffee("Latte");
        coffeeVendingMachine.dispenseCoffee(latte, new Payment(4.0));
    }

//    Espresso - $2.5
//    Latte - $3.0
//    Cappuccino - $3.5
//    Dispensing: Espresso
//    Processing Payment ...
//    Please collect your change: $0.5
//    Dispensing: Cappuccino
//    Processing Payment ...
//    Exception in thread "main" java.lang.RuntimeException: Insufficient ingredient to make Latte
//    at coffeevendingmachine.CoffeeVendingMachine.dispenseCoffee(CoffeeVendingMachine.java:55)
//    at coffeevendingmachine.CoffeeVendingMachineDemo.main(CoffeeVendingMachineDemo.java:22)

}
