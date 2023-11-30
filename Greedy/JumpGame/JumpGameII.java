package Greedy.JumpGame;

public class JumpGameII {
    public int jump(int[] nums) {
        // We find minmal jump we can take at each index
        int farthest_jump = 0, curr_jump = 0, jump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest_jump = Math.max(i + nums[i], farthest_jump);
            if (i == curr_jump) {
                // It means we have made the minimal jump at that index
                curr_jump = farthest_jump;
                jump++;
            }
        }
        return jump;
    }
}
