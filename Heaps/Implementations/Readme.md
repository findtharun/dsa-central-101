| Operation       | Time Complexity (Average/Amortized) | Time Complexity (Worst Case) |
| --------------- | ----------------------------------- | ---------------------------- |
| Insert          | O(log n)                            | O(log n)                     |
| Extract Min/Max | O(log n)                            | O(log n)                     |
| Peek            | O(1)                                | O(1)                         |
| Update          | O(log n)                            | O(log n)                     |
| Delete          | O(log n)                            | O(log n)                     |
| Search          | O(n)                                | O(n)                         |
| Build Heap      | O(n)                                | O(n log n)                   |

Build Heap Takes O(n\* log n) as for each insert we have o(log n)

### Check if Given Array Represents Max Heap

```
static boolean isHeap(int arr[], int n) {
    for (int i = 0; i <= (n - 2) / 2; i++) {
        // If left child is greater, return false
        if (arr[2 * i + 1] > arr[i]) {
            return false;
        }

        // If right child is greater, return false
        if (2 * i + 2 < n && arr[2 * i + 2] > arr[i]) {
            return false;
        }
    }
    return true;
}
```

### Check if Given Array Represents Min Heap

```
static boolean isHeap(int arr[], int n) {
    for (int i = 0; i <= (n - 2) / 2; i++) {
        // If left child is smaller, return false
        if (arr[2 * i + 1] < arr[i]) {
            return false;
        }

        // If right child is smaller, return false
        if (2 * i + 2 < n && arr[2 * i + 2] < arr[i]) {
            return false;
        }
    }
    return true;
}
```
