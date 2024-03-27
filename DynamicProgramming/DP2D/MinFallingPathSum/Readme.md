https://leetcode.com/problems/minimum-falling-path-sum/

This Problems has Multiple Sources, Multiple Destinations

|        Approach        | Time Complexity | Space Complexity |
| :--------------------: | :-------------: | :--------------: |
|       Recursion        |   O(3^(M+N))    |      O(M*N)      |
| Top Down / Memoization |     O(M\*N)     |     O(M\*N)      |
| BottomUp / Tabulation  |     O(M\*N)     |     O(M\*N)      |
|   Space Optimization   |     O(M\*N)     |       O(N)       |

Note : Though Memoization , Tabulation have same space Complexity, Memoization uses more since in recursion stack will always exist till end.