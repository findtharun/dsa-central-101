https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1

https://www.codingninjas.com/studio/problems/count-subsets-with-sum-k_3952532

In this Problem , Array contains 0 - Hence base case changes a lot.

- If we just want to find whether subset has sum with K , then no changes.
- However, if we want the count of subsets with sum k then logic has to be updated.
    - Ex : [0,0,1] --  HasSubset Logic gives 2, However answer is 4 . (Count subsets with sum k has the exact solution)

|        Approach        | Time Complexity |     Space Complexity      |
| :--------------------: | :-------------: | :-----------------------: |
| Top Down / Memoization |     O(n\*k)     | O(n\*k) + Recursive Stack |
| BottomUp / Tabulation  |     O(n\*k)     |          O(n\*k)          |