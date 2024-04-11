https://leetcode.com/problems/longest-string-chain/description/

Since Order doesn't matter, we can sort teh array

| Approach | Time Complexity | Space Complexity |               Notes               |
| :------: | :-------------: | :--------------: | :-------------------------------: |
|   LIS    |   O(n\*n\*l)    |       O(n)       | l is the length of Longest String |
| HashMap  |   O(n\*l\*l)    |       O(n)       |     l is length of each word      |

HashMap approach is slightly faster than LIS.

Explanation for LIS Approach : https://takeuforward.org/data-structure/longest-string-chain-dp-45/

Explanation for HashMap Approach : https://www.youtube.com/watch?v=pXG3uE_KqZM
