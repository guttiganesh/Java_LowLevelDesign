package LLD.TicTacToe;

import LLD.TicTacToe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;
    int size;

    TicTacToeGame(int size){
        this.size = size;
        InitializeGame(size);
    }

    private void InitializeGame(int size) {
        players = new LinkedList<>();
        PlayingPiece pieceX = new PlayingPieceX();
        Player p1 = new Player(pieceX,"player1");
        PlayingPiece pieceO = new PlayingPieceO();
        Player p2 = new Player(pieceO,"player2");
        players.add(p1);
        players.add(p2);
        gameBoard = new Board(size);
    }

    public String startGame(){
        boolean nowinner = true;
        while(nowinner){
            Player playerTurn = players.removeFirst();
            gameBoard.printBoard();
            List<int[]> freeSpaces = gameBoard.getFreeSpaces();
            if(freeSpaces.isEmpty()){
                nowinner = false;
                continue;
            }
            System.out.println("Player : "+playerTurn.getName() + "  Enter row,col : ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.parseInt(values[0]);
            int col = Integer.parseInt(values[1]);
            boolean isSuccess = gameBoard.addPeice(row,col,playerTurn.getPlayingPiece());
            if(!isSuccess){
                System.out.println("Incorredt possition chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);
            boolean isWinner = checkForWinner(row,col,playerTurn.playingPiece.pieceType);
            if(isWinner) return playerTurn.getName();
        }
        return "tie";
    }

    private boolean checkForWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        for(int i=0;i<size;i++){
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType){
                rowMatch = false;
            }
        }
        for(int i=0;i<size;i++){
            if(gameBoard.board[i][col] == null || gameBoard.board[i][col].pieceType != pieceType){
                colMatch = false;
            }
        }
        for(int i=0,j=0;i < size;i++,j++){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType){
                diagonalMatch = false;
            }
        }
        for(int i=0,j=size-1;i < size;i++,j--){
            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType){
                antiDiagonalMatch = false;
            }
        }
        return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
    }

}
