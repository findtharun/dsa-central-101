Problem Statement : https://leetcode.com/problems/search-a-2d-matrix/

| Approach | Time Complexity | Space Complexity |Comments|
| :---:         |     :---:      |         :---: | :---:|
| Brute Force  | O(N*M)     |  O(1) | 
|  Binary Search |  O(N+logM)  |   O(1)    |  Do Binary Search Only on a Particular Row By Checking First and Last| 
| Binary Search Optimal  | O(log(N*M))   | O(N)  | Search like a 1D Array| 

The Last Approach is Hypothetical . We fLatten 2D to 1D with out traversing entire Matrix. Hence Time Complexity is Much Less.