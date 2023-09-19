package StackAndQueue.StockSpan;

public class BruteForce {
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int[] span = new int[n];
        for(int i=0;i<n;i++){
            span[i] =1 ;
            for(int j=i-1;j>=0 && price[j]<=price[i];j--){
                span[i]++;
            }
        }
        return span;
    }
}
