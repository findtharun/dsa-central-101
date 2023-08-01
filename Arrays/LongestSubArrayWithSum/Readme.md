<b> Problem Statement </b> : https://takeuforward.org/arrays/longest-subarray-with-sum-k-postives-and-negatives/

| Approach | Time Complexity | Space Complexity|
| :---:         |     :---:      |         :---: |
| Brute Force   | O(N*N)     |  O(1) |
|  Hashing |  O(N*logn)  |   O(N)    |
| Two Pointers   | O(N) + O(NlogN)    | O(N)  |

<h4> For Tow Pointers Approach</h4>

Note: The Approach would only work for Incase of Postives and Zeroes. If the Array has Negatives, Hashmap is Optimal Approach.