https://leetcode.com/problems/longest-increasing-subsequence/description/

- Recursion Takes O(2^n) because at each step we make 2 recursive calls.

|        Approach        | Time Complexity |     Space Complexity      |
| :--------------------: | :-------------: | :-----------------------: |
| Top Down / Memoization |     O(n\*n)     | Recursive Stack + O(n\*n) |
| BottomUp / Tabulation  |     O(n\*n)     |          O(n\*n)          |
|   Space Optimization   |     O(n\*n)     |           O(n)            |
|   Standard Approach    |     O(n\*n)     |           O(n)            |
| Binary Search Approach |   O(n\*logn)    |           O(n)            |

NOTE : Binary Search approach can only give length not subsequence, Standard Approach is preferred for printing Subsequence.
