package snakeandladder;

public class Dice {

    private final int minValue;
    private final int maxValue;


    public Dice(int start, int end) {
        this.minValue = start;
        this.maxValue = end;
    }

    public int roll() {
        return (int)Math.random() * (maxValue - minValue + 1) + minValue;
    }
}
