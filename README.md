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

<h2> Best Resources for Preparation</h2>

* Neetcode - https://www.youtube.com/@NeetCode/playlists
* Striver's DSA Sheet : https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/
* https://www.enjoyalgorithms.com/

<h3> Best Explanations(Theortical / Visually)
* Best Theory Explanations
    * Abdul Bari
* Best Visual Explanations
    * https://www.youtube.com/@insidecode/videos
    * https://www.youtube.com/@TechWithNikola/videos


<h2> Best Problems Listed </h2>

* https://www.designgurus.io/blind75
* https://neetcode.io/practice
* https://algo.monster/dashboard
<h2> Best Videos/Blogs for Learning</h2>

* Datastructures in Java : https://youtu.be/WqDvLBOaWXY
