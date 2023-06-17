import java.util.*;
import java.util.LinkedList;

public class GenerateBinNum {
    public static String[] generateBin(int n){
        String res[] = new String[n];
        Queue<String> q = new LinkedList<>();

        q.add("1");
        for(int i=0; i<n; i++){
            res[i] = q.remove();

            String n1 = res[i] + "0";
            String n2 = res[i] + "1";
            q.add(n1);
            q.add(n2);
        }
        return res;
    }

    public static void main(String args[]){
        int n = 5;

        String res[] = generateBin(n);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+ " ");
        }
    }
}
