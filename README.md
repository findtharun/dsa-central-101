# DSA Central 101
This Repository Contains Various Approaches to Solving a Problem,  Serves as a Guide to Preparing for Interviews

### How to Avoid TLE 
*  Number of Elementary Operations that can be done in 1 Sec is 10^8. If your algorithm is achieving it in <=10^8 (Including Constraints), then we can use bruteforce approach to solve the problem. 

Use the information in a question to your advantage! It will often implicitly tell you how efficient your algorithm should be to get full points. Consider the fact that a computer can run 108 iterations per second. You’re usually going to be given an array or string; call its size n. Note that you cannot be asked to come up with a solution better than O(n) in this case (even if one exists); the reason is that it takes linear time to input the test array itself! With that in mind,

- If (n >= 10^4), aim for a O(n) or a O(n log n) solution.
- If (n <= 10^3), aim for a O(n2) solution
- I(n <= 10^2), aim for a O(n3) solution
- If (n < 20), a O(2n) solution should be fine.

* Detailed Complexity for each constraint can be found here : https://www.geeksforgeeks.org/overcome-time-limit-exceedtle/
* https://discuss.codechef.com/t/no-of-operations-computations-in-1-second-java/13889

## Time Complexities of Common Operations for Java Collections

| Operation                        | ArrayList           | LinkedList          | HashSet   | HashMap   | TreeMap   |
|----------------------------------|---------------------|---------------------|-----------|-----------|-----------|
| Access (get)                     | O(1)                | O(n)                | N/A       | N/A       | O(log n)  |
| Search (contains)                | O(n)                | O(n)                | O(1)      | O(1)      | O(log n)  |
| Insert (add at end)              | O(1)                | O(1)                | O(1)      | O(1)      | O(log n)  |
| Insert (add at specific index)   | O(n)                | O(n)                | N/A       | N/A       | O(log n)  |
| Delete (remove at end)           | O(1)                | O(1)                | O(1)      | O(1)      | O(log n)  |
| Delete (remove at specific index)| O(n)                | O(n)                | N/A       | N/A       | O(log n)  |
| Sort (using default comparator)  | O(n log n)          | O(n log n)          | N/A       | N/A       | O(n log n)|
| Sort (using custom comparator)   | O(n log n)          | O(n log n)          | N/A       | N/A       | O(n log n)|
| Count Occurrences                | O(n)                | O(n)                | O(n)      | O(n)      | O(n)      |
| Synchronized View                | O(1)                | O(1)                | O(1)      | O(1)      | O(1)      |
| Unmodifiable View                | O(1)                | O(1)                | O(1)      | O(1)      | O(1)      |

Note:
- ArrayList and LinkedList are different implementations of the List interface.
- HashSet, HashMap, and TreeMap are implementations of the Set and Map interfaces.
- N/A indicates that the operation is not applicable for that particular data structure.
- Synchronized View: Functions like Collections.synchronizedList(), Collections.synchronizedSet(), and Collections.synchronizedMap() return synchronized (thread-safe) views of the specified collections.

- Unmodifiable View: Functions like Collections.unmodifiableList(), Collections.unmodifiableSet(), and Collections.unmodifiableMap() return unmodifiable views of the specified collections, making them read-only.

### Best Resources for Preparation

* DSA Concepts & Program Implemnetation Visually : https://opendsa-server.cs.vt.edu/ODSA/Books/Everything/html/index.html 
* Neetcode - https://www.youtube.com/@NeetCode/playlists
* Striver's DSA Sheet : https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/
* GFG SDE Sheet : https://geeksforgeeks.org/sde-sheet-a-complete-guide-for-sde-preparation/
* https://github.com/TheAlgorithms
* https://www.enjoyalgorithms.com/
* https://github.com/ashishps1/awesome-leetcode-resources
* Algorithms : https://www.algorithm-archive.org/
* https://www.techinterviewhandbook.org/
* https://github.com/jwasham/coding-interview-university
* Problems : https://www.techiedelight.com/
* https://github.com/ashishps1/awesome-leetcode-resources
* https://cp-algorithms.com/


### Best Explanations(Theortical / Visually)

* Best Theory Explanations
    * Abdul Bari
* Best Visual Explanations
    * https://www.youtube.com/@SpanningTree
    * https://www.youtube.com/@insidecode/videos
    * https://www.youtube.com/@TechWithNikola/videos
    * https://www.youtube.com/@Reducible
    


### Best Problems Listed

* https://www.designgurus.io/blind75
* https://www.techinterviewhandbook.org/grind75
* https://neetcode.io/practice
* https://algo.monster/dashboard
* https://cses.fi/problemset/  (https://github.com/Jonathan-Uy/CSES-Solutions)
* https://www.interviewcake.com/
* Leetcode Problems Company Wise : https://leetracer.com/screener

### Best Videos/Blogs for Learning Java

* Java Core Concepts in Detail : https://jenkov.com/
* https://www.geeksforgeeks.org/java/
* Datastructures in Java : https://youtu.be/WqDvLBOaWXY
* Collections in Java : https://www.youtube.com/playlist?list=PLFGoYjJG_fqoDQHufg7XVk-yb2w6CNpgF

### Best Tools / Sites for Understanding Algorithms and Problems

* Java Code Visulizer : https://pythontutor.com/java.html
* Algorithms Visualization
    * https://algorithm-visualizer.org/
    * https://www.cs.usfca.edu/~galles/visualization/Algorithms.html
    * https://visualgo.net/
* Height Map Visualizer : https://editor.p5js.org/LeweyM/full/RpAxMlZL4

### CheatSheets
* https://www.piratekingdom.com/leetcode/templates
* https://github.com/Chanda-Abdul/Several-Coding-Patterns-for-Solving-Data-Structures-and-Algorithms-Problems-during-Interviews/tree/main
