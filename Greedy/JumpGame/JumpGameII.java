package Greedy.JumpGame;

public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int destination = n - 1;
        int coverage = 0;
        int lastJumpIdx = 0;
        int totalJumps = 0;
        if (n == 1)
            return 0;
        for (int i = 0; i < n; i++) {
            coverage = Math.max(coverage, i + nums[i]);
            if (i == lastJumpIdx) {
                lastJumpIdx = coverage;
                totalJumps++;
            if (coverage >= destination)
                return totalJumps;
            }
        }
        return totalJumps;
    }
}
