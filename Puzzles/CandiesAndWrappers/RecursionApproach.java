package Puzzles.CandiesAndWrappers;

public class RecursionApproach {
    public static int rec(int candies, int allowed_wrappers_exchange) {
        if (candies < allowed_wrappers_exchange)
            return 0;

        int extra_candies = candies / allowed_wrappers_exchange;

        return extra_candies + rec(extra_candies + candies % allowed_wrappers_exchange, allowed_wrappers_exchange);
    }

    public static int chocolateFeast(int budget, int cost, int allowed_wrappers_exchange) {
        // Write your code here
        int candies = budget / cost; // Initial Candies
        return candies + rec(candies, allowed_wrappers_exchange);
    }

    public static void main(String[] args) {
        int budget = 10;
        int cost = 1;
        int allowed_wrappers_exchange = 3;
        System.out.print(chocolateFeast(budget, cost, allowed_wrappers_exchange));
    }
}
