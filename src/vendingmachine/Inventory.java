package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Item> itemMap = new HashMap<>();
    private final Map<String, Integer> stockMap = new HashMap<>();



    public synchronized void addItem(String code, Item item, int quantity) {
        itemMap.put(code, item);
        stockMap.put(code, quantity);
    }

    public boolean isAvailable(String code) {
        return stockMap.getOrDefault(code, 0) > 0;
    }

    public void reduceStock(String code) {
        stockMap.put(code, stockMap.get(code) - 1);
    }

    public Item getItem(String code) {
        return itemMap.get(code);
    }
}
