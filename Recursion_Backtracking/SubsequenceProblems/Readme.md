## All about Subsequences

Subsequences are Contagious / Non Contagious sequences which follow True Order.

#### Generating Subseqeunces

```
path.add(arr[index]); // Take the Current Element
printSubsequences(arr, index + 1, path);
path.remove(path.size()-1); // Do Not Take Current Element
printSubsequences(arr, index + 1, path);

```
