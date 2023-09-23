package Puzzles.CandiesAndWrappers;

//we noticed that after finding the initial number of chocolates, we recursively divide the number of chocolates by the number of wrappers required. 
//until we left with 1 chocolate or wrapper. We are recomputing the values i.e. ((choc/wrap + choc%wrap)/wrap until we get 1. 
//It is observed that we can get the result by just reducing the values of chocolates and wrappers by 1 and then divide them to get the result (choc-1)/(wrap-1) 

public class LogicalIntuition {
    public static int chocolateFeast(int budget, int cost, int allowed_wrappers_exchange) {
        // Write your code here
        int candies = budget / cost; // Initial Candies
        candies = candies + (candies - 1) / (allowed_wrappers_exchange - 1);
        return candies;
    }

    public static void main(String[] args) {
        int budget = 10;
        int cost = 1;
        int allowed_wrappers_exchange = 3;
        System.out.print(chocolateFeast(budget, cost, allowed_wrappers_exchange));
    }
}
