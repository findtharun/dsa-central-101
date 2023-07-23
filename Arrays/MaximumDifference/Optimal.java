package Arrays.MaximumDifference;

public class Optimal {
    int maxDiff(int[] nums, int n){
        int max_diff =-1; int min_ele = nums[0];
        for(int i=1;i<n;i++){
            if (nums[i]>min_ele){
                max_diff = Math.max(max_diff, nums[i]-min_ele);
            }else{
                min_ele = Math.min(min_ele, nums[i]);
            }
        }
        return max_diff;
    }

    public static void main(String[] args){
        int[] arr = {1,5,2,10};
        int n = arr.length;
        Optimal obj = new Optimal();
        System.out.print("Maximum Difference : ");
        System.out.print(obj.maxDiff(arr,n));
    }
}
