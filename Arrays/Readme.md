<h2> Tips and Tricks </h2>

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
```
|            | Definition                                  | Example                        |
|------------|---------------------------------------------|--------------------------------|
| Subset     | A selection of elements from a set or array - 2^n Subsets | `3`,`1`. `2`, `31`, `32`, `312`,` `, |
| Subarray   | A contiguous subset of elements in an array | `[3]`, `[1, 2]`, `[1]`, `[2]`, `[3, 1]`, `[1, 2]`, `[3, 1, 2]` |
| Subsequence| A sequence derived by deleting elements from the original sequence without changing their order | `3`, `1`, `2`, `31`, `32`, `312`, `321` |



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

<h2> Interesting Problems </h2>

* https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/


<h2> Best Tutorials and Blogs</h2>