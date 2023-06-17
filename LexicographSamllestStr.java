public class LexicographSamllestStr {
    public static void main(String args[]){
        int  n = 5, k = 73;

        char res[] = new char[n];
        for(int i = 0; i < res.length; i++){
            res[i] = 'a';
        }

        k -= n;

        while(k > 0){
            res[n-1] += Math.min(25, k);
            k -= Math.min(25, k);
            n--;
        }

        for(int i = 0; i < res.length; i++){
            System.out.print(res[i]);
        }
    }
}
