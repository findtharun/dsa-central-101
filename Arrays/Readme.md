<h2> Tips and Tricks </h2>

* Whenever you're trying to solve an array problem in place, always consider the possibility of iterating backwards instead of forwards through the array. It can completely change the problem, and make it a lot easier.

* Most of the Array Problems Can be solved using
    * Sorting
    * HashMap
    * Two Pointers
    * Slow Pointer and Speed Pointer
    * Sliding Window
    * Prefix Sum
    * Marking Visited or Playing With Indices
    * Maths Formulas (If they are 1 to N)

### Subsets vs Subsequences vs Subarray 

```
Array = [3,1,2]
No. of Elements in 
    Subarray = n*(n+1)/2
    Subseqeunce = (2^n) -1 (non-empty subsequences)
    Subset = 2^n
```
|            | Definition                                  | Example                        |
|------------|---------------------------------------------|--------------------------------|
| Subset     | A selection of elements from a set or array - 2^n Subsets | `3`,`1`. `2`, `31`, `32`, `321`,` `, |
| Subarray   | A contiguous subset of elements in an array | `[3]`, `[1, 2]`, `[1]`, `[2]`, `[3, 1]`, `[1, 2]`, `[3, 1, 2]` |
| Subsequence| A sequence derived by deleting elements from the original sequence without changing their order | `3`, `1`, `2`, `31`, `32`, `312` |



<h2> Useful Snippets </h2>

<h4> Sorting Arrays</h4>
Since Collections does not work with Primitive, Declared Integer Class.

```
Integer[] freq = new Integer[26];
Arrays.fill(freq,0);

Arrays.sort(freq,Collections.reverseOrder());

 Collections.sort(arrayList, Collections.reverseOrder());

```
<h4> Finding Sub Arrays </h4>

```
for( int i=0; i<len; i++ ){
    for( int j=i; j<len; j++ ){   // Now A[i..j] is the subarray
        for( int k=i; k<=j; k++ )
            printf("%d ", A[k]);
        printf("\n");
    }
}
```
#### Converting ArrayList to Array

- 1D : listName.toArray(new int[listName.size()]);
- List<int[]> to 2D Array : listName.toArray(new int[listName.size()][]);
- We can not convert List<List>> directly to 2D array, Instead convert every List to 1D array and Assign Manually else we need to use Streams to Perform in 1 Line.

<h2> Interesting Problems </h2>

* https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/


<h2> Best Tutorials and Blogs</h2>