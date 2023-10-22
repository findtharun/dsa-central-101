

<h2> HashMap Internal Implementation </h2>

From JDK8, HashMap uses <b> Balanceed Binary Tree </b> for Handling Collision Instead of Linked List after
Threshold of 8 Values. (This will Reduce Search from O(N) to O(logN) if many keys are stored at Same Index)

* HashMap Can Contain Null Keys, (Hash Code would be zero, Hence Index would be 0).
* If a Key already Exists in HashMap, the value is replaced with new Value.