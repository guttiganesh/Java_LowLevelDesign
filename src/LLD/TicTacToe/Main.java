package LLD.TicTacToe;

public class Main {
    public static void main(String[] args){
        TicTacToeGame game = new TicTacToeGame(3);
        System.out.println("game winner is: " + game.startGame());
    }
}
