<b> Problem Statement </b> : https://leetcode.com/problems/majority-element/description/

| Approach | Time Complexity | Space Complexity|
| :---:         |     :---:      |         :---: |
| Brute Force   | O(N*N)     |  O(1) |
|  HashMap |  O(N*logN)   |   O(N)    |
| Moore's Voting Algo   | O(N) | O(1)  |

 We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN). 