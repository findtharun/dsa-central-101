Length of Longest Subsequence : https://leetcode.com/problems/longest-common-subsequence/description/

Print Longest Subsequence : https://www.naukri.com/code360/problems/print-longest-common-subsequence_8416383

- Recursion Takes O(2^(n1+n2)) because at each step we make 2 recursive calls.

|        Approach        | Time Complexity |      Space Complexity       |
| :--------------------: | :-------------: | :-------------------------: |
|       BruteForce       |    O(n1\*n2)    |            O(1)             |
| Top Down / Memoization |    O(n1\*n2)    | O(n1\*n2) + Recursive Stack |
| BottomUp / Tabulation  |    O(n1\*n2)    |          O(n1\*n2)          |

```
Though the Worst Case Time Complexities for Brute Force and DP are Same , in reality DP always executes faster.
1. DP (Memoization) Will not have to pass through all possibilities.
2. DP (Tabulation) it stores the results of subproblems in a table.
3. DP Solutions are scalable for larger inputs.
```
