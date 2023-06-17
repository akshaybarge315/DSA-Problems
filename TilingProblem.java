public class TilingProblem {

    public static int tilingProb(int n) { // 2 x n Floor Size 
        // Base Case
        if( n == 0 || n == 1){
            return 1;
        }

        // kaam
        // vertical choice
        int fnm1 = tilingProb(n-1);

        // Horizontal choice
        int fnm2 = tilingProb(n-2);

        int totalways = fnm1 + fnm2;
        return totalways;
    }

    public static void main(String args[]){
        System.out.println(tilingProb(4));
    }
}
