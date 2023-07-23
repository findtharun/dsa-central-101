package Arrays.MajorityElement;

public class MooreVoting {
    public int majorityElement(int[] nums) {
        int win = nums[0];
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (win == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                win = nums[i];
                cnt = 1;
            }
        }
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == win)
                cnt1++;
        }
        if (cnt1 > (n / 2))
            return win;
        return -1;
    }

    public static void main(String args[]) {
        int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
        MooreVoting obj = new MooreVoting();
        System.out.print("Majority Element : ");
        System.out.print(obj.majorityElement(arr));
    }

}
