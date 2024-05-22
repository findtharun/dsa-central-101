- <b> SubString </b> : Ity is obtained by selecting characters from the original string <b> _without deleting_ </b> any characters and keeping their original order.
- <b> SubSequence </b> : It is obtained by <b>_deleting some or no elements_</b> without changing the order of the remaining elements.

```
Order of Characters from Original string should remain the same for Both

Eg : S = ABC
Sub Strings : AB, BC
SubSequences : AB, AC, BC
```
- Substring Problems Solution Patterns : https://leetcode.com/problems/minimum-window-substring/solutions/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems/
<h2> Tips & Tricks </h2>

- Convert Int to String ; int a = 222; String st = a + "";
- Whenever solving Problems with Strings : convert the string to char array instead of using .charAt, the code will be much faster.
