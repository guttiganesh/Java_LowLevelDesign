package LLD.TicTacToe.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public PlayingPiece[][] board;
    public int size;

    public Board(int size) {
        this.board = new PlayingPiece[size][size];
        this.size = size;
    }

    public boolean addPeice(int i,int j,PlayingPiece playingPiece){
        if(board[i][j] != null) return false;
        board[i][j] = playingPiece;
        return true;
    }
    public List<int[]> getFreeSpaces(){
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == null) res.add(new int[]{i,j});
            }
        }
        return res;
    }
    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] != null){
                    System.out.print(board[i][j].pieceType.name()+"   ");
                }else{
                    System.out.print("    ");
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}
