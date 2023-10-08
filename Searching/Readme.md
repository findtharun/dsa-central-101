# Searching Algorithms

* Linear Search / Sequential 

## Binar Search 
* It follows Divide and Conquer Approach.
* It delivers better performance than Sequential Search by sorting the elements in the collection in advance of the query. Binary Search divides the sorted collection in half until the sought-for item is found, or until it is determined that the item cannot be present in the smaller collection.

* However, if Data is Dynamic and Size is Huge, Standard Binary Search is in efficient.
An alternate method is to create a <b> binary search tree </b> in memory. This approach can be simple to implement if the insertions and deletions are random enough that the tree does not become too biased. It addresses the case in which the data is both dynamic and too large to fit into memory. When this occurs, the search time is dominated by input/output operations to secondary storage. One effective solution is to use an n-ary tree called a <b>B-Tree </b>. This is a multilevel tree that is <u><i>fine-tuned for performance on secondary storage </i></u>.

## Hash-Based Search
* Standard Binary Search is inefficient with dynamic data as an array is used to store the collection, insertions and deletions are quite inefficient, since every array entry should contain a valid element. Therefore, inserting involves extending the array (physically or logically) and pushing on average half of the elements ahead one slot. Deletion requires shrinking the array and moving half of the elements one index position lower. Neither of these is acceptable.

As long as the collection fits in memory, a good choice is to switch to a hash-based search approach using collision chaining.
