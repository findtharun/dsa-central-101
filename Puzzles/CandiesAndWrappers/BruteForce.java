package Puzzles.CandiesAndWrappers;

public class BruteForce {

    public static int chocolateFeast(int budget, int cost, int allowed_wrappers_exchange) {
        // Write your code here
        int candies = budget / cost; // Initial Candies
        int wrappers = budget / cost; // Wrappers of Initial Candies

        // Exchanging Wrappers and calculating Extra Candies
        while (wrappers>= allowed_wrappers_exchange) {
            candies += wrappers / allowed_wrappers_exchange;
            wrappers = wrappers / allowed_wrappers_exchange + wrappers % allowed_wrappers_exchange;
        }
        return candies;
    }

    public static void main(String[] args) {
       int budget = 10;
       int cost = 2;
       int allowed_wrappers_exchange = 5;
       System.out.print(chocolateFeast(budget,cost,allowed_wrappers_exchange));
    }
}
