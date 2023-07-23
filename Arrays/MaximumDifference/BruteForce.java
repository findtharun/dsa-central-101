package Arrays.MaximumDifference;
public class BruteForce {
    int maxDiff(int[] nums, int n){
        int max_diff =-1;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j]>nums[i])
                max_diff = Math.max(nums[j]-nums[i],max_diff);
            }
        }
        return max_diff;
    }
    public static void main(String[] args){
        int[] arr = {1,5,2,10};
        int n = arr.length;
        BruteForce obj = new BruteForce();
        System.out.print("Maximum Difference : ");
        System.out.print(obj.maxDiff(arr,n));
    }
}
