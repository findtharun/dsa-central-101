https://leetcode.com/problems/coin-change/

- Recursion Takes O(n^amount) because at each step we make 2 recursive calls.

|        Approach        | Time Complexity |        Space Complexity        |
| :--------------------: | :-------------: | :----------------------------: |
| Top Down / Memoization |  O(n\*amount)   | O(n\*amount) + Recursive Stack |
| BottomUp / Tabulation  |  O(n\*amount)   |          O(n\*amount)          |
|   Space Optimization   |  O(n\*amount)   |           O(amount)            |
