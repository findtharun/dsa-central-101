A Graph is a non-linear data structure consisting of vertices and edges. The vertices are sometimes also referred to as nodes and the edges are lines or arcs that connect any two nodes in the graph. More formally a Graph is composed of a set of vertices( V ) and a set of edges( E ). The graph is denoted by G(V, E).

<h3> Terminology </h3>

- Vertices u and v are Nieghbours if an Edge Connects them.
- Degree : Number of Edges Connected to Node. (In Degree + Out Dgree)
  _ In Degree : No. of Incoming Edges
  _ Out Degress : No.of Outgoing Edges from Node
  <b>><i> Total Degree of Undirected Graph = 2\* (No.of Edges) </i></b>
- <b> Path </b> (Simple): A Walk in Which No vertices (Thus No Edges) are repeated
  - Path Length : Number of Edges in a Path.
- <b> Trail </b> : A Walk in Which No Edges are Repeated.
<h4> Connectivity </h4>

- Two Vertices are connected if there is a path exists between them.
- A Graph is connected if all its nodes are connected (There Exists a path b/w all nodes).
- <b> <i> If Graph is Directed we call the connected Graph as Strongly Connected </i></b>
- <b> Connected Component </b> : a subset of vertices that is connected.

<h3> Types of Graphs </h3>

- Directed, Undirected
- Connected Graph : The graph in which from one node we can visit any other node in the graph is known as a connected graph.
- Disconnected Graph : The graph in which at least one node is not reachable from a node is known as a disconnected graph.
- Regular Graph : The graph in which the degree of every vertex is equal to K is called K regular graph.
- Complete Graph : The graph in which from each node there is an edge to each other node.
- Directed cyclic Graphs : Contains atleast One Cycle.
- Directed Acyclic Graphs (<b>DAG </b>) : Contains No cycles . DAG has lot of applications, widely used.
- Weighted Graph : Edges have weights.

- Trees (Undirected Acyclic Graphs)
  - Trees are Connected Graph and Acyclic
  - Removing any edge in Tree Disconnects Graph
  - Adding any Edge Makes it Cyclic

<h3> Properties of Graphs </h3>

- Maximum No.of Edges for N Nodes (If there is no Cycle or Multi Edges)
  - Directed : N\*(N-1)
  - UnDirected : N\*(N-1)/2

| No.Of Edgges                             | Graph Name   | Representation   |
| ---------------------------------------- | ------------ | ---------------- |
| Too Many Edges                           | Dense Graph  | Adjacency Matrix |
| Less Edges (Almost equal to No.of Nodes) | Sparse Graph | Adjacency List   |

- Most real world Graphs are Sparse.

- If a Graph has a Cycle with Odd Number of Nodes - It can never be BiPartite.

<h3> Representation of Graphs </h3>

- Adjacency Matrix : Graph is stored in the form of the 2D matrix where rows and columns denote vertices. Each entry in the matrix represents the weight of the edge between those vertices
  Ex : Path Finding Algorithms(Prims / Djkstras),
- Adjacency List : Graph is represented as a collection of linked lists. There is an array of pointer which points to the edges connected to that vertex.
  Ex : World Wide Web , Social Network are represented in Adjaceny List.

| Action           | Adjacency Matrix | Adjacency List |
| ---------------- | ---------------- | -------------- |
| Adding Edge      | O(1)             | O(1)           |
| Removing an Edge | O(1)             | O(N)           |
| Initializing     | O(N\*N)          | O(N)           |

- Edge List : Edges are Stored in a List. It is not efficient in terms Any Operation, Not considered.

<h3> Applications </h3>

- Graphs can be used to represent the topology of computer networks, such as the connections between routers and switches, Routing Algorithms.
- Neural Networks, Social Media
- Shortest Path Algorithms, Travelling Salesman
- Resolving Package Dependencies in Software
- Image Segmentation - Network Flow (Computer Vision)
- Web Crawlers
- Sudoku Can be solved using Graphs.

### Best Problems Listed

* https://leetcode.com/discuss/study-guide/2360573/Become-Master-In-Graph

## Deep Dive of Graph Algorithms

* https://www.whitman.edu/mathematics/cgt_online/book/
* Network Flow : https://www.youtube.com/watch?v=LdOnanfc5TM&list=PLDV1Zeh2NRsDj3NzHbbFIC58etjZhiGcG
