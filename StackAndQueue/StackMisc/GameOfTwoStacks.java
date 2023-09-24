package StackAndQueue.StackMisc;

import java.util.List;

public class GameOfTwoStacks {

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        int sum = 0;
        int st1_count = 0;
        int st2_count = 0;
        int res = 0;
        for (int i = 0; i < a.size(); i++) {
            if (sum + a.get(i) > maxSum)
                break;
            sum += a.get(i);
            st1_count++;
        }
        res = st1_count;
        for (int i = 0; i < b.size(); i++) {
            sum = sum + b.get(i);
            st2_count++;
            while (sum > maxSum && st1_count > 0) {
                sum = sum - a.get(st1_count - 1);
                st1_count--;
            }
            if (sum <= maxSum) {
                res = Math.max(st1_count + st2_count, res);
            }
        }
        return res;

    }
}
