package snakeandladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private final int size;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;


    Board(int boardSize, List<Snake> snakes, List<Ladder> ladders) {
        this.size = boardSize;
        this.snakes = new HashMap<>();
        this.ladders = new HashMap<>();

        for(Snake snake : snakes) {
            this.snakes.put(snake.getHead(), snake.getTail());
        }

        for(Ladder ladder1: ladders) {
            this.ladders.put(ladder1.getStart(), ladder1.getEnd());
        }
    }

    public int getSize() {
        return size;
    }

    public int getNextPossition(int currentPosition) {

        if(snakes.containsKey(currentPosition)) {
            currentPosition = snakes.get(currentPosition);
        } else if(ladders.containsKey(currentPosition)) {
            currentPosition = ladders.get(currentPosition);
        }

        return currentPosition;
    }


}
