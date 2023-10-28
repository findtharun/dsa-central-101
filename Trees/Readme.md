Tree Data Structure is a hierarchical data structure in which a collection of elements known as nodes are connected to each other via edges such that there exists exactly one path between any two nodes.

<h3> Properties </h3>

* Depth of a node: The depth of a node is defined as the length of the path from the root to that node.
* Height of a node: The height of a node can be defined as the length of the longest path from the node to a leaf node of the tree.
* Degree of a Node: The total count of subtrees attached to that node is called the degree of the node. The degree of a leaf node must be 0.

Note : Trees have Only Height, Depth is only for Node.

```
The degree of a tree is the maximum degree of a node among all the nodes in the tree.
```
<h2> Types of Tree </h2>

* Binary Tree
* Ternary Tree
* N Ary Tree

<h3> Types of Binary Tree </h3>

| Type                    | Property            | Interesting Fact    |
|-------------------------|---------------------|---------------------|
| Full Binary Tree        | Binary Tree in which every node has 0 or 2 children | Number of Leaf nodes = Number of Internal nodes + 1 | Huffman Coding Tree is Full Binary Tree
| Complete Binary Tree    | All levels completely filled with nodes except the last level and in the last level, all the nodes are as left side as possible.| Binary Heap is an important use case of Complete Binary tree.|
| Perfect Binary Tree     | Internal nodes have 2 children and all the leaf nodes are at the same depth or same level.| Total number of nodes in a Perfect Binary Tree with height H is 2^H — 1.|
| Balanced Binary Tree    |Binary tree in which height of the left and the right sub-trees of every node may differ by at most 1.|  Height of The Tree should be log(N) at max. AVL Tree and Red-Black Tree are well-known data structure to generate/maintain Balanced Binary Search Tree. |
| Degenerated Binary Tree | Binary Tree where every parent node has only one child node.|Height of a Degenerate Binary Tree is equal to Total number of nodes in that tree.|

<h2> Useful Resources </h2>

* Tree Basics By CS Dojo : https://www.youtube.com/watch?v=1-l_UOFi1Xw
* Introduction to Trees : https://www.geeksforgeeks.org/introduction-to-tree-data-structure-and-algorithm-tutorials
* Types of Tress & Characteristics : https://towardsdatascience.com/5-types-of-binary-tree-with-cool-illustrations-9b335c430254
* Deep Dive on Types of Trees : https://www.geeksforgeeks.org/types-of-trees-in-data-structures/
