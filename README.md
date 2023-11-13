# The_DSA_Den
This Repository Contains Various Approaches to Solving a Problem,  Serves as a Guide to Preparing for Interviews
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
* https://www.enjoyalgorithms.com/
* https://opendsa-server.cs.vt.edu/ODSA/Books/Everything/html/index.html
* https://github.com/ashishps1/awesome-leetcode-resources

### Best Explanations(Theortical / Visually)

* Best Theory Explanations
    * Abdul Bari
* Best Visual Explanations
    * https://www.youtube.com/@insidecode/videos
    * https://www.youtube.com/@TechWithNikola/videos


### Best Problems Listed

* https://www.designgurus.io/blind75
* https://neetcode.io/practice
* https://algo.monster/dashboard
* Sorting and Searching : https://cses.fi/problemset/

### Best Videos/Blogs for Learning Java

* Java Core Concepts in Detail : https://jenkov.com/
* https://www.geeksforgeeks.org/java/
* Datastructures in Java : https://youtu.be/WqDvLBOaWXY
* Collections in Java : https://www.youtube.com/playlist?list=PLFGoYjJG_fqoDQHufg7XVk-yb2w6CNpgF

### Best Tools / Sites for Understanding Algorithms and Problems

* Java Code Visulizer : https://pythontutor.com/java.html
* Algorithms Visualization  : https://www.cs.usfca.edu/~galles/visualization/Algorithms.html
* Height Map Visualizer : https://editor.p5js.org/LeweyM/full/RpAxMlZL4

### CheatSheets
* https://www.piratekingdom.com/leetcode/templates
