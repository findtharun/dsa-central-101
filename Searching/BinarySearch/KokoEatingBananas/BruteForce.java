package Searching.BinarySearch.KokoEatingBananas;
//https://leetcode.com/problems/koko-eating-bananas/description/
public class BruteForce {
    public int minEatingSpeed(int[] piles, int h) {
        int k=1;
        int n = piles.length;
        int maxi = Integer.MIN_VALUE;;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        while(k<=maxi){
            int sum = 0;
            for(int i=0;i<n;i++){
               sum+=Math.ceil((double)piles[i]/(double)k);
            }
            if(sum<=h) return k;
            else k++;
        }
        return maxi;
    }
}
