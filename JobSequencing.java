import java.util.*;

public class JobSequencing {

    static class Job{
        char jobId;
        int deadline;
        int profit;
        
        Job(char i, int d, int p){
            jobId = i;
            deadline = d;
            profit = p;
        }
    }

    public static void JobScheduling(Job arr[]){
        int n = arr.length;

        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        // Find maximum deadline to create the deadline array
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxi) {
                maxi = arr[i].deadline;
            }
        }

        int result[] = new int[maxi+1];

        // Assign -1 to all deadline array
        for(int i=1; i<maxi; i++){
            result[i] = -1;
        }

        int countJob = 0; 
        int jobProfit = 0;

        for(int i=0; i<n; i++){
            // from array access deadline
            for(int j=arr[i].deadline; j>0; j--){
                 if(result[j] == -1){
                    char jobID = arr[i].jobId; 
                    System.out.print(jobID + " ");

                    result[j] = i;
                    countJob++;
                    jobProfit += arr[i].profit;
                    break;
                 }
            }
        }
        System.out.println();
        System.out.println("Count of Job : "+ countJob);
        System.out.println("Total Profit : "+ jobProfit);
    }


    public static void main(String args[]){
        Job arr[] = new Job[4];

        arr[0] = new Job('a', 4, 20);
        arr[1] = new Job('b', 1, 10);
        arr[2] = new Job('c', 1, 40);
        arr[3] = new Job('d', 1, 30);

        JobScheduling(arr);
    }
}
