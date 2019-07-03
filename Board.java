import java.util.Arrays;
import java.util.*;

public class Board{
    public int[][] board;

    public Board(int[][] board){
        this.board = board;
    }

    public int getelement(Square square){
        return board[square.row][square.col];
    }

    //methods
    public HashSet<Integer> getrow(Square square){
        HashSet<Integer> rowresult = new HashSet<Integer>();
        for (int i = 0; i < 9; i++){
            if (board[square.row][i] !=0){
                Square s = new Square(square.row,i);
                rowresult.add(getelement(s));
            }
        }
        return rowresult;
    }

    public HashSet<Integer> getcol(Square square){
        HashSet<Integer> colresult = new HashSet<Integer>();
        for (int i = 0; i < 9; i++){
            if (board[i][square.col] != 0){
                Square s = new Square(i, square.col);
                colresult.add(getelement(s));
            }
        }
        return colresult;
    }

    public HashSet<Integer> getbigsqu(Square square){
        HashSet<Integer> bigsqu = new HashSet<Integer>();
        int rowsrange = (square.row/3)*3;
        int colsrange = (square.col/3)*3;
        int squrow = -1;
        for (int a = rowsrange; a < (rowsrange + 3); a ++){
            squrow += 1;
            int squcol = -1;
            for (int b = colsrange; b < (colsrange + 3); b++){
                squcol += 1;
                if (board[a][b] != 0){
                    Square z = new Square(a,b);
                    bigsqu.add(getelement(z));
                }
            }
        }
        return bigsqu;
    }

    public ArrayList<Square> getfreesquares(){
        ArrayList<Square> free_squares = new ArrayList<Square>();
        for (int a = 0; a < 9; a++){
            for (int b = 0; b < 9; b++){
                Square s = new Square(a,b);
                if (getelement(s) == 0){
                    free_squares.add(s);
                }
            }
        }
        return free_squares;
    }

    public ArrayList<Integer> getlegalelems(Square square){
        HashSet<Integer> mid = new HashSet<Integer>() {{
                      addAll(getcol(square));
                      addAll(getrow(square));
                      addAll(getbigsqu(square));}};
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int a = 1; a < 10; a++){
            if (! mid.contains(a)){
                result.add(a);
            }
        }
        return result;
    }

    public void insertItem(Square square, int item){
        board[square.row][square.row] = item;
    }

    public String boardToString(){
        return Arrays.deepToString(board);
    }

    // public static void main(String[] args){
    //     int[][] board = new int[][]{{8, 0, 0, 0, 0, 0, 0, 0, 0 },
    //     { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
    //     { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
    //     { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
    //     { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
    //     { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
    //     { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
    //     { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
    //     { 0, 9, 0, 0, 0, 0, 4, 0, 0 }};
    //     Board b = new Board(board);
    //     Square s = new Square(1,0);
    //     b.insertItem(s, 9);
    //     System.out.println(b.boardToString());
    // }
}
