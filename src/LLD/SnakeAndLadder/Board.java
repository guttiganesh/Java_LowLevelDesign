package LLD.SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;
    //In n x n matrix size is n
    int size;

    public Board(int boardSize,int numberOfSnakes,int numberOfLadders) {
        size = boardSize;
        initializeBoard(boardSize);
        addSnakesAndLadders(cells,numberOfSnakes,numberOfLadders);
    }

    private void initializeBoard(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                Cell cell = new Cell();
                cells[i][j] = cell;
            }
        }
    }

    private void addSnakesAndLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {
        int n = cells.length;
        int boardSize = n * n;
        while(numberOfSnakes > 0){
            int snakeStart = ThreadLocalRandom.current().nextInt(1,boardSize-1);
            int snakeEnd = ThreadLocalRandom.current().nextInt(1,boardSize-1);
            if(snakeStart > snakeEnd){
                Jump snakeJump = new Jump();
                snakeJump.start = snakeStart;
                snakeJump.end = snakeEnd;
                Cell cell = getCell(snakeStart);
                cell.jump = snakeJump;
            }
            numberOfSnakes--;
        }
        while(numberOfLadders > 0){
            int ladderStart = ThreadLocalRandom.current().nextInt(1,boardSize-1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1,boardSize-1);
            if(ladderEnd > ladderStart){
                Jump ladderJump = new Jump();
                ladderJump.start = ladderStart;
                ladderJump.end = ladderEnd;
                Cell cell = getCell(ladderStart);
                cell.jump = ladderJump;
            }
            numberOfLadders--;
        }
    }

    public Cell getCell(int position){
        return cells[position / size][position % size];
    }
}
