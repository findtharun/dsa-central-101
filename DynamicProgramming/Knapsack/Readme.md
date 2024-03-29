https://www.geeksforgeeks.org/introduction-to-knapsack-problem-its-types-and-how-to-solve-them/

In Knapsack Solution, DP[i][i] represents how much weight can be taken Till ith Index If Max Capacity is j.

|         0/1 Knapsack          | 0/1 Knapsack |             Unbounded              | Bounded |
| :---------------------------: | :----------: | :--------------------------------: | :-----: |
| Item can be Taken only _once_ |              | Item can be Taken _Infinite_ Times |         |
|                               |      -       |                                    |    -    |
|               -               |      -       |                                    |    -    |
