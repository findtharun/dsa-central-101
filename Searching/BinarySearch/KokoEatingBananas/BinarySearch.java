package Searching.BinarySearch.KokoEatingBananas;
//https://leetcode.com/problems/koko-eating-bananas/description/
public class BinarySearch {
    public static int calculateTotalHours(int[] v, int hourly) {
        int totalH = 0;
        int n = v.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double)(v[i]) / (double)(hourly));
        }
        return totalH;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int maxi = Integer.MIN_VALUE;;
        //find the maximum
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        int low=1; int high = maxi; int res = maxi;
        while(low<=high){
            int mid = (low+high)/2;
            int totalH = calculateTotalHours(piles, mid);
            if(totalH<=h) {
                high=mid-1;
                res = mid;
            }
            else{
                low = mid+1;
            }
        }
        return res;
    }
}
