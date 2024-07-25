Given a integer array 'a' with 'n' elements, find the length of the longest subsequence where a[j]-a[i]=1 given j>i . The order should remain the same.

In other words, it's longest increasing subsequence were diff between two consecutive element is 1

a = [2, 3, 1, 4, 3, 5, 6]
output: 5
Explanation: the logest subsequence will be [2, 3, 4, 5, 6]

| Approach | Time Complexity | Space Complexity | Notes |
| :------: | :-------------: | :--------------: | :---: |
| Standard |     O(n\*n)     |       O(n)       |       |
| HashMap  |      O(n)       |       O(n)       |       |
