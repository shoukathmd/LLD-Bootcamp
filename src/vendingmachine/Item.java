package vendingmachine;

import vendingmachine.states.State;

public class Item {
    private final String code;
    private final String name;
    private final int price;

    public Item(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
