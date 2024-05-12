Was asked in One of DE Shaw Online Assesment round

https://leetcode.com/discuss/interview-question/5084258/DE-SHAW-OA-or-28-APR-2024-or-SMT-or-SOFTWARE-DEVELOPER-(BACKEND)-or
https://leetcode.com/discuss/interview-question/5112734/D.E-Shaw-oror-OA-ororsoftware-dev.

### Question
Given an array of integers arz, an integer, sum Val, the task is to pair the elements in arr into interesting pairs. Find the number of interesting pairs in the array. An unordered pair (1) is defined to be interesting if arrarlarr, armsumValle, the sum of absolute difference and absolute sun at the values in respective indices is equal to sumval). The goal is to find the number of interesting pairs in the array.

Example:
arr= [1,4,-1,2]
sumVal=4

Then, there are two interesting pairs, (1, 4) and (3, 4)
Because, |arr1-arr4| + |arr1 +arr4| = |1-2| + |1+2| =4.
|arr3-arr4| + |arr3 +arr4| = |-1-2| + |-1+2| =4.

### Intuition

We can consider examples like (2,1), (-1,-2), (2,-1), (-2,1), all will give the same result of 4. So we can treat all numbers as positive. To make that sum, we can find the numbers equal to sum/2(let's say same) and absolute numbers less than sum/2(let's say less). Then we can make a pair in 2 ways :

Selecting 2 numbers from same which is same*(same-1)/2
Selecting one from same and one from less which is same*less




