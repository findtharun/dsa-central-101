https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

- Recursion Takes O(2^(n+wt)) because at each step we make 2 recursive calls.

Memoization approach here is Branch and Bound.

|        Approach        | Time Complexity |      Space Complexity      |
| :--------------------: | :-------------: | :------------------------: |
| Top Down / Memoization |    O(n\*wt)     | O(n\*wt) + Recursive Stack |
| BottomUp / Tabulation  |    O(n\*wt)     |          O(n\*wt)          |
|   Space Optimization   |    O(n\*wt)     |           O(wt)            |
