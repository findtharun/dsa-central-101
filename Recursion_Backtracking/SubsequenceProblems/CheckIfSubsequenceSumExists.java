package Recursion_Backtracking.SubsequenceProblems;

public class CheckIfSubsequenceSumExists {
    public static boolean helper(int [] arr, int ind, int N,int currSum,int K){
        if(ind == N){
             if(currSum == K) return true;
             return false;
        }
       if(currSum > K) return false;
        
        currSum = currSum + arr[ind];
        if(helper(arr,ind+1, N, currSum ,K) == true)
             return true;
         currSum = currSum - arr[ind];
         if(helper(arr,ind+1, N, currSum ,K) == true)
             return true;
        return false; 
     }
    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
     // code here
     return helper(arr, 0, N, 0,K);
   }
}
