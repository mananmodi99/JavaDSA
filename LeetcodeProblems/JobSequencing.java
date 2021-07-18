package LeetcodeProblems;
import java.util.*;
public class JobSequencing {
    class Job
    {
        // Each job has a unique-id,
        // profit and deadline
        char id;
        int deadline, profit;

        // Constructors
        public Job() {}

        public Job(char id, int deadline, int profit)
        {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }
    int[] JobScheduling(Job arr[], int n)
    {
        int prof = 0, job = 0;
        Arrays.sort(arr, new Comparator<Job>(){
            @Override
            public int compare(Job j1, Job j2){return j2.profit - j1.profit;}
        });
        boolean[] abhitak = new boolean[500];
        for(int i = 0; i<arr.length; i++){
            for(int j = arr[i].deadline-1; j>=0; j--){
                if(abhitak[j] == false){
                    job++;
                    abhitak[j] = true;
                    prof += arr[i].profit;
                    break;
                }
            }

        }
        int[] ans = new int[]{job, prof};
        return ans;

    }
}
