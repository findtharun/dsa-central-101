https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954

- Recursion Takes O(2^N*K) because at each step we make 2 recursive calls.

|        Approach        | Time Complexity |     Space Complexity      |
| :--------------------: | :-------------: | :-----------------------: |
| Top Down / Memoization |     O(n\*k)     | O(n\*k) + Recursive Stack |
| BottomUp / Tabulation  |     O(n\*k)     |          O(n\*k)          |
|   Space Optimization   |     O(n\*k)     |           O(k)            |

NOTE : dp[i][j] tells whether you can achieve subset with sum J Till ith Index of the Array.

With Memoization Approach, all Cells will not be filled in DP, But since our target is only last cell --  It works.

<h3> When Array contains Zero </h3>

- If we just want to find whether subset has sum with K , then no changes.
- However, if we want the count of subsets with sum k then logic has to be updated.
    - Ex : [0,0,1] --  HasSubset Logic gives 2, However answer is 4 . (Count subsets with sum k has the exact solution)
