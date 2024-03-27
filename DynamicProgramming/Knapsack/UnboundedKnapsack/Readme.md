https://www.naukri.com/code360/problems/unbounded-knapsack_1215029

- Recursion Takes O(2^(n+wt)) because at each step we make 2 recursive calls.

|        Approach        | Time Complexity |      Space Complexity      |
| :--------------------: | :-------------: | :------------------------: |
| Top Down / Memoization |    O(n\*wt)     | O(n\*wt) + Recursive Stack |
| BottomUp / Tabulation  |    O(n\*wt)     |          O(n\*wt)          |
|   Space Optimization   |    O(n\*wt)     |           O(wt)            |
