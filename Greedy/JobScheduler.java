package Greedy;

import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class JobScheduler {
    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Sorting Based on Profit in Decreasing Order
        Arrays.sort(arr, new Comparator<Job>() {
            public int compare(Job a, Job b) {
                return b.profit - a.profit;
            }
        });
        int max_jobs = -1;
        for (int i = 0; i < arr.length; i++)
            max_jobs = Math.max(arr[i].deadline, max_jobs);

        int[] res = new int[max_jobs + 1]; // 0th index would not be considered
        Arrays.fill(res, -1); // All Slots are Open
        res[0] = Integer.MIN_VALUE; // Assigning Value other than -1

        int jobs_profit = 0;
        int jobs_completed = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (res[j] == -1) {
                    // Job can be done, We always try to do the job on last possible day
                    res[j] = i;
                    jobs_profit += arr[i].profit;
                    jobs_completed++;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = jobs_completed;
        ans[1] = jobs_profit;
        return ans;
    }
}
