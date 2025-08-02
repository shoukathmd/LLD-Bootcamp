package snakeandladder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final Queue<Player> players;
    private final Dice dice;
    private boolean isGameOver;

    public Game(Builder builder) {
        this.board = builder.board;
        this.players = new LinkedList<>(builder.players);
        this.dice = builder.dice;
        this.isGameOver = false;
    }


    public void play() {

        while(!isGameOver) {
            Player player = players.poll();
           // int diceRoll = dice.roll();
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            int newPosition = player.getCurrentPosition() + number;

            if(newPosition <= board.getSize()) {
                player.setCurrentPosition(board.getNextPossition(newPosition));
                System.out.println(player.getName() + " rolled a " + number +
                        " and moved to position " + player.getCurrentPosition());
            }


            if(player.getCurrentPosition() == board.getSize()) {
                System.out.println("Player : " + player.getName() + " has won the game");
                isGameOver = true;
                break;
            }
            players.offer(player);
        }
    }

    public static class Builder {
        private  Board board;
        private  Queue<Player> players;
        private  Dice dice;

        public Builder setBoart(Board board) {
            this.board = board;
            return  this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = new LinkedList<>(players);
            return this;
        }

        public Builder setDice(Dice dice) {
            this.dice = dice;
            return this;
        }

        public Game build() {
            if(board == null || players == null || dice == null) {
                throw new IllegalStateException("Board, players and dice must be set.");
            }

            return new Game(this);
        }
    }
}
