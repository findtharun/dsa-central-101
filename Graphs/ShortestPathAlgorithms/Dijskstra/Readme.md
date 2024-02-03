## Dijkstra Algorithm

Different Approaches for Finding Shortest Path from Source to All nodes using Dijkastra's Algorithm

1. Using Priority Queue (Recommended)
    * Time Complexity : O( E log(V) )
    * Space Complexity : O( |E| + |V| )
2. Using Sets
    * Time Complexity is Almost equivalent to O( E log(V) )
    * Space Complexity  : O( |E| + |V| )

But Set Always Tries to Sort all things, Hence Would Take More Time, Where as Priority Queue Implementation we will get the Smallest one , rest of the heap need not be sorted always.

Time Complexity Explanation : https://youtu.be/3dINsjyfooY

### Limitations

Dijkstra Fails when there are Negative Edges, Gets TLE when there is Negtaive Cycle.
 (Bellman Ford, Floyd Warshal Algorithms can be used in that case).