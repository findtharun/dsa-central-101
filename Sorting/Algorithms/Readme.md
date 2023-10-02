<h2> Sorting Algorithms Comparison </h2>

<b> Stable Sorting Algorithms </b> Manitains the Relative Order of Elements When there is a Tie(i.e If Values are Same)
| Algorithms        |         Property         |
| ------------- | --------------------- |
| Bubble Sort, Insertion Sort, Merge Sort | Stable     |
| Quick Sort, Selection Sort, Heap Sort      | Unstable           |

<b> Adaptiive Sorting Algorithms </b> checks if the array is sorted alreeady after each pass, breaks . Thus They are efficient.
| Algorithms        |         Property         |
| ------------- | --------------------- |
| Bubble Sort, Insertion Sort, Quick Sort  | Adaptive     |
| Selection Sort, Merge Sort, Heap Sort      | Not Adaptive    |

## Sorting Algorithm Time Complexities

| Algorithm     | Best Case | Average Case | Worst Case |
| ------------- | --------- | ------------ | ---------- |
| **Bubble Sort** | O(n)      | O(n^2)       | O(n^2)     |
| **Selection Sort** | O(n^2)   | O(n^2)       | O(n^2)     |
| **Insertion Sort** | O(n)    | O(n^2)       | O(n^2)     |
| **Merge Sort** | O(n log n) | O(n log n)  | O(n log n) |
| **Quick Sort** | O(n log n) | O(n log n)  | O(n^2)     |
| **Heap Sort** | O(n log n) | O(n log n)  | O(n log n) |

These are the time complexities for common sorting algorithms. Understanding these complexities helps in choosing the right sorting algorithm for your specific needs.

<h2> Selection Sort </h2>

Selection sort has various real-world applications, especially in scenarios where simplicity is preferred over performance, or the dataset is relatively small. Here are some real-world examples:

* Sorting a list of students by their grades or names in a small class.
* Organizing files in a directory by their creation date or size.
* Sorting a deck of cards in ascending or descending order.
* Arranging a list of items by price in a small e-commerce store.

<h2> Bubble Sort </h2>

* Bubble sort is Mostly used for eductional Purposes and Teaching.

<h2> Insertion Sort </h2>

* We can not get any results (such as smallest or Largest unlike bubble/ selection sort). 
* Insertion sort more opertion intensive for arrays, It is manily developed to Sort LinkedList.