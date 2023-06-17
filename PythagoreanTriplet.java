public class PythagoreanTriplet {
    public static boolean Pythagorean(int n){
        int x = (int)Math.sqrt(n);
        return x * x == n;
    }

    public static int solve(int A) {
        int count = 0;
        for(int i= 1; i<A; i++){
            for(int j = i+1; j<A; j++){   
                int k = i*i + j*j;       // TC : O(n^2)
                if(Pythagorean(k) && Math.sqrt(k) <= A){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String args[]){
        int A = 13;
        System.out.println(solve(A));
    }
}
