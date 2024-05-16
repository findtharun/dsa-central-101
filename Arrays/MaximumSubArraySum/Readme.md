<b> Problem Statement </b> :

- https://leetcode.com/problems/maximum-subarray

Explanation for Kadane's Algo : https://www.youtube.com/watch?v=86CQq3pKSUw

|  Approach   | Time Complexity | Space Complexity |
| :---------: | :-------------: | :--------------: |
| Brute Force |     O(N\*N)     |       O(1)       |
|  Kadane's   |      O(N)       |       O(1)       |

NOTE : The Solution of Kadane's Will also work for Complete Negative Array. Because of Below Lines. We carry only Positive Sum.

```
if (sum < 0)
    sum = 0;
```