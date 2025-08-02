package snakeandladder;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderDemo {


    static void run() {

        List<Snake> snakeList = Arrays.asList(new Snake(35, 15));
        List<Ladder> ladders = Arrays.asList(new Ladder(13, 37));
        Board board = new Board(100, snakeList, ladders);
        Dice dice = new Dice(1, 100);

        List<Player> playerList = Arrays.asList(new Player("Test1", 0), new Player("Test2", 0));
        //Game needs board, dice and players

        Game game = new Game.Builder()
                .setBoart(board)
                        .setDice(dice)
                                .setPlayers(playerList)
                                        .build();



        game.play();
    }

    public static void main(String[] args) {
        run();
    }
}
