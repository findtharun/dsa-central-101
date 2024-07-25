Recursively Remove Duplicate Adjacent Characters : https://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/

This Solution can not be done using Stack as it does not work for all Cases.
Consider the Test Case : abccbccba

Expected output : ""
Stack Approach Output : aba

Note : Both Approaches use Recursion
| Approach  | Time Complexity | Space Complexity |                  Notes                   |
| :-------: | :-------------: | :--------------: | :--------------------------------------: |
| Recursive |     O(N\*N)     |       O(N)       | It is close to O(N\*N) but never O(N\*N) |
| Regex     |     O(N\*N)     |       O(N)       | It is close to O(N\*N) but never O(N\*N) |


<b> There can not be any solution without recursion  </b>. If we have condition to remove a particular count of adjacent characters then we can eleminate recursion (ex : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/) 