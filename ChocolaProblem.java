import java.util.*;
public class ChocolaProblem {
    public static void main(String args[]){
        int n=4, m=5;
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int v = 0, h = 0;
        int vp = 1, hp = 1;
        int cost = 0;

        while(v < costVer.length && h < costHor.length){
            if(costVer[v] <= costHor[h]){  // Horizontal cut
                cost += (costHor[h] * vp);
                hp++;
                h++;
            }else{  // Vertical cut
                cost += (costVer[v] * hp);
                vp++;
                v++;
            }
        }

        // for remaining horizontal cuts
        while(h < costHor.length){
            cost += (costHor[h] * vp);
            hp++;
            h++;
        }

        // for remaining Vertical cuts
        while(v < costVer.length){
            cost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Min cost is " + cost);
    }
}
