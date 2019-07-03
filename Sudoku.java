import java.util.Arrays;
import java.util.*;
public class Sudoku{

    public Board board;

    public Sudoku(Board board){
        this.board = board;
    }

    public Boolean solved(){
        HashSet<Integer> numbers = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        for (int a = 0; a < 9; a++){
            Square s  = new Square(a,a);
            if (board.getrow(s) == numbers){
                if (board.getcol(s) == numbers){
                    if (board.getbigsqu(s) == numbers){
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    //to call on all empty squares
    public Boolean solveSudoku(){
        if (board.getfreesquares().size() == 0 && solved()){
            return true;
        }
        for(int row = 0; row < 9;row++){
            for(int col = 0; col < 9; col++){
                Square s = new Square(row,col);
                if (board.getelement(s) == 0){
                    for(int i = 1; i < 10; i++){
                        if(board.getlegalelems(s).contains(i)){
                            board.insertItem(s,i);
                            if(solveSudoku()){
                                return true;
                            }
                            board.insertItem(s,0);
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int [][] preboard = new int[][]
                                        {
                                {9,0,0,1,0,0,0,0,5},
                                {0,0,5,0,9,0,2,0,1},
                                {8,0,0,0,4,0,0,0,0},
                                {0,0,0,0,8,0,0,0,0},
                                {0,0,0,7,0,0,0,0,0},
                                {0,0,0,0,2,6,0,0,9},
                                {2,0,0,3,0,0,0,0,6},
                                {0,0,0,2,0,0,9,0,0},
                                {0,0,1,9,0,4,5,7,0},
                                };

        Board board = new Board(preboard);

        String solution = board.boardToString();
        System.out.println(solution);

        Sudoku game = new Sudoku(board);
        game.solveSudoku();

        solution = board.boardToString();
        System.out.println(solution);

    }
}
