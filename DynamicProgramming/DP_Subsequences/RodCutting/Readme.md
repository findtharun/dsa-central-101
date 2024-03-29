https://www.naukri.com/code360/problems/rod-cutting-problem_800284

- Recursion Takes O(2^(n+n+1)) because at each step we make 2 recursive calls.

|        Approach        | Time Complexity |      Space Complexity      |
| :--------------------: | :-------------: | :------------------------: |
| Top Down / Memoization |    O(n\*n+1)     | O(n\*n+1) + Recursive Stack |
| BottomUp / Tabulation  |    O(n\*n+1)     |          O(n\*n+1)          |
|   Space Optimization   |    O(n\*n+1)     |           O(n+1)            |