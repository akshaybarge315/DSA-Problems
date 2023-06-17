public class FriendPairs {
    public static int FriendPairing(int n){
        // Base Case
        if(n == 1 || n == 2){
            return n;
        }

        // Kaam
        int Fnm1 = FriendPairing(n-1);
        int Fnm2 = FriendPairing(n-2);
        int PairWays = (n-1) * Fnm2;
        int totalways = Fnm1 + PairWays;
        return totalways;
    }

    public static void main(String args[]){
        System.out.print(FriendPairing(3));
    }
}
