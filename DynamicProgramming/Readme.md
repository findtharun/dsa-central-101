# Dynamic Programming (DP)

Dynamic Programming (DP) is a powerful algorithmic technique used to solve optimization problems by breaking them down into simpler subproblems and solving each subproblem only once, storing the results to avoid redundant calculations. It is particularly useful when the problem can be divided into overlapping subproblems, allowing the results of these subproblems to be reused.

## Key Concepts

- **Optimal Substructure**: The optimal solution to the original problem can be constructed from the optimal solutions of its subproblems. (Ex : Bellman Ford Algo, Floyd Warshall Algo
  
- **Overlapping Subproblems**: The problem can be broken down into smaller subproblems, and the same subproblems are encountered multiple times during the computation. (Ex : Fibonacci)

## Approaches

There are two common approaches to implementing dynamic programming:

- **Top-Down Approach (Memoization)**: This approach involves solving the original problem recursively by breaking it down into smaller subproblems. Memoization is used to store the results of solved subproblems, ensuring that each subproblem is only solved once.

    * It consists of recursion and caching.

- **Bottom-Up Approach (Tabulation)**: In this approach, the problem is solved by iteratively solving all smaller subproblems and using their solutions to solve larger subproblems. It involves building up solutions from the bottom by starting with the smallest subproblems and progressively solving larger ones.

### Identify DP Problems
- Typically, all the problems that require maximizing or minimizing certain quantities or counting problems that say to count the arrangements under certain conditions or certain probability problems can be solved by using Dynamic Programming.
All dynamic programming problems satisfy the overlapping subproblems property and most of the classic Dynamic programming problems also satisfy the optimal substructure property.

## Usage

Dynamic Programming is applicable to a wide range of optimization problems, including:
- Shortest Path Problems
- Knapsack Problems
- Sequence Alignment

## Resources

- [GeeksforGeeks - Dynamic Programming](https://www.geeksforgeeks.org/dynamic-programming/)
- [TopCoder - Dynamic Programming Tutorial](https://www.topcoder.com/thrive/articles/Dynamic%20Programming:%20From%20Novice%20to%20Advanced)