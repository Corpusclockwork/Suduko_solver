public class Square{

    public final int row;
    public final int col;

    public Square(int row, int col){
        this.row = row;
        this.col = col;
    }

    public String squareToString(){
        return "(" + row + "," + col + ")";
    }
    
}
