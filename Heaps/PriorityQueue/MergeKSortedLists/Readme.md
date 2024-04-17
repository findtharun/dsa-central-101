https://leetcode.com/problems/merge-k-sorted-lists/

Sorting in Place - Similar to Merge 2 Sorted Lists (No extra space) : but time consuming , explanation can be found here : https://www.youtube.com/watch?v=1zktEppsdig

|    Approach    |                   Time Complexity                    | Space Complexity |
| :------------: | :--------------------------------------------------: | :--------------: |
|   BruteForce   |      O(M) + O(MlogM) Sorting + O(M) ; M = N\*K       |   O(M) + O(M)    |
| Priority Queue | O(klogk) Priority Quue Insertion + O(N\*K) Traversal |       O(K)       |
