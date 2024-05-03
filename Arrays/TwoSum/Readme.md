<b> Problem Statement </b> : Given an array of integers arr[] and an integer target.
Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

|   Approach   | Time Complexity | Space Complexity |
| :----------: | :-------------: | :--------------: |
| Brute Force  |     O(N\*N)     |       O(1)       |
|   Hashing    |      O(N)       |       O(N)       |
| Two Pointers | O(N) + O(NlogN) |       O(N)       |

<h4> For Hashing Approach</h4>

Reason: The loop runs N times in the worst case and searching in a hashmap takes O(1) generally. So the time complexity is O(N).

Note: In the worst case(which rarely happens), the unordered_map takes O(N) to find an element. In that case, the time complexity will be O(N2). If we use map instead of unordered_map, the time complexity will be O(N\* logN) as the map data structure takes logN time to find an element.

<h3> Other Variants of Problem</h3>
https://www.issacc.com/2sum-3sum-4sum-xsum/
