Problem : https://www.geeksforgeeks.org/minimum-number-operation-required-convert-number-x-y/

|      Approach       | Time Complexity | Space Complexity |
| :-----------------: | :-------------: | :--------------: |
| Graph Intuition BFS |     O(X+Y)      |       O(N)       |
|       Optimal       |     O(X-Y)      |       O(1)       |

In the Optimal approach, we will check the least most bit of the number and take a decision according to the value of that bit.

Instead of converting x into y, we will convert y into x and will reverse the operations which will take the same number of operations as converting x into y.
