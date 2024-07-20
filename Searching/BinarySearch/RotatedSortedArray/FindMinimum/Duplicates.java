package Searching.BinarySearch.RotatedSortedArray.FindMinimum;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

// The Below Solution Gives Lower Bound Index
public class Duplicates {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0; int r = n-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r]){
                l = mid+1;
            }else if(nums[mid] < nums[r]){
                r = mid;
            }else{
                r--;
            }
        }
        return nums[l] ;
    }
}
