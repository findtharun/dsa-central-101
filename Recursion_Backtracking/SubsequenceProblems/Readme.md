## All about Subsequences

Subsequences are Contagious / Non Contagious sequences which follow True Order.

#### Generating Subseqeunces

```
printSubsequences(arr, index + 1, new ArrayList<>(path)); // Do Not Take Current Element
path.add(arr[index]); // Take the Current Element
printSubsequences(arr, index + 1, new ArrayList<>(path));

```
