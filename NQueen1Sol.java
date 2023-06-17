public class NQueen1Sol {
    public static boolean isSafe(char board[][], int row, int col){
        // vertical Up
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // Diagonal left up
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        // Diagonal Right up
        for(int i=row-1, j= col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    public static boolean nQueen(char board[][],int row){
        // Base Case
        if(row == board.length){
            // printBoard(board);
            return true;
        }

        // Recursion i.e Column loop
        for(int j=0; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if(nQueen(board, row+1)){
                    return true;
                }
                board[row][j] = 'x'; // backtracking step
            }
            
        }

        return false;
    }

    // Printing Pattern
    public static void printBoard(char board[][]){
        System.out.println("---- Chess Board ----");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        int n = 4;
        char board[][] = new char[n][n];

        // Initialize
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = 'x';
            }
        }

        if(nQueen(board, 0)){
            System.out.println("Solution is Possible");
            printBoard(board);
        }else{
            System.out.println("Solution is Not Possible");
        }
    }
}
