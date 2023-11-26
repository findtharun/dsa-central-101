A heap is defined by two properties. 

1. It is a complete binary tree, so heaps are nearly always implemented using the array representation for [complete binary trees](https://opendsa-server.cs.vt.edu/ODSA/Books/Everything/html/CompleteTree.html#completetree). 
2. The values stored in a heap are partially ordered. This means that there is a relationship between the value stored at any node and the values of its children.

### Types of Heaps
1. A <b> max heap </b> has the property that every node stores a value that is greater than or equal to the value of either of its children. Because the root has a value greater than or equal to its children, which in turn have values greater than or equal to their children, the root stores the maximum of all values in the tree.

2. A <b> min heap </b> has the property that every node stores a value that is less than or equal to that of its children. Because the root has a value less than or equal to its children, which in turn have values less than or equal to their children, the root stores the minimum of all values in the tree.