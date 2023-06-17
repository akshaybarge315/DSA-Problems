// Not SOlved

public class KnightsTour {
    public static boolean isSafe(int knight[][], int row, int col){
        if(row < 0 || col < 0 || row > knight.length || col > knight.length && knight[row][col] > 0){
            return false;
        }
        return true;
    }

    public static void knightsTour(int knight[][], int row, int col, int move){
        if(knight[row][col] == knight.length * knight.length){
            printBoard(knight, move);
            return;
        }
       
        if(isSafe(knight, row, col)){
            knight[row][col] = move;
            knightsTour(knight, row+2, col+1, move+1);
            knightsTour(knight, row+1, col+2, move+1);
            knightsTour(knight, row-1, col+2, move+1);
            knightsTour(knight, row+2, col-1, move+1);
            knightsTour(knight, row-2, col-1, move+1);
            knightsTour(knight, row-2, col+1, move+1);
            knightsTour(knight, row+1, col-2, move+1);
            knightsTour(knight, row-1, col-2, move+1);
            
            knight[row][col] = 0;
        }
    }

    public static void printBoard(int knight[][],int move){
        for(int i=0; i<knight.length; i++){
            for(int j=0; j<knight.length; j++){
                System.out.print(knight[i][j] = move);
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        int n = 8;
        int knight[][] = new int[n][n];

        knightsTour(knight, 0, 0, 1);
    }
}
