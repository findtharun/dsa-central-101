* For Undirected Graphs
    * This BFS [Solution](Basics/UndirectedGraph.java) works however, it takes much time. Dijkstra can be used.
* For DAG
    * Dijkstra is Slower for Finidng Shortest Path in DAG. Modified Toposort can be used. Check [Solution](Basics/DAGUsingTopoSort.java)

| Algorithm    | Purpose                                    | Edge Weight  | Negative Edge Weights | Negative Cycles |
| ------------ | ------------------------------------------ | ------------ | --------------------- | --------------- |
| Dijkstra's   | Shortest path from single source           | Non-negative | Incorrect results     | Doesn't detect  |
| Bellman-Ford | Shortest path from single source           | Any          | Correct results       | Detects         |
