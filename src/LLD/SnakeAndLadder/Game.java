package LLD.SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Deque<Player> playersList;
    Dice dice;
    Player winner;

    public Game(){
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10,5,4);
        dice = new Dice(1);
        winner = null;
        playersList = new LinkedList<>();
        addPlayers();
    }

    private void addPlayers() {
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        playersList.add(player1);
        playersList.add(player2);

    }

    public void startGame(){
        while(winner == null){
            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn with id : " + playerTurn.id + " at position : "+playerTurn.currentPosition);
            int diceSum = dice.rollDice();
            System.out.println("Dice roll is : "+diceSum);
            int playerNewPosition = findNewPosition(diceSum,playerTurn);
            System.out.println("Player id : "+playerTurn.id + " new position is : "+playerNewPosition);
            playerTurn.currentPosition = playerNewPosition;
            if(playerNewPosition >= board.size * board.size - 1)  winner = playerTurn;
        }
        System.out.println("Winner is "+winner.id);
    }

    private int findNewPosition(int diceSum, Player playerTurn) {
        int position = diceSum + playerTurn.currentPosition;
        if(position >= board.size * board.size -1) return position;
        Cell cell = board.getCell(position);
        if(cell.jump != null && cell.jump.start == position){
            Jump jump = cell.jump;
            System.out.println(jump.start > jump.end ? "Snake Jump" : "Ladder Jump");
            position = jump.end;
            return position;
        }
        return position;
    }

    private Player findPlayerTurn() {
        Player player = playersList.removeFirst();
        playersList.addLast(player);
        return player;
    }
}
