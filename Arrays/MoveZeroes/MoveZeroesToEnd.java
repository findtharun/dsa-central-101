package Arrays.MoveZeroes;

public class MoveZeroesToEnd{

    // Approach 1
void pushZerosByCount(int arr[], int n)
{
    int count = 0;  // Count of non-zero elements
    for (int i = 0; i < n; i++)
        if (arr[i] != 0)
            arr[count++] = arr[i];
    while (count < n)
        arr[count++] = 0;
}

// Approach 1
void pushZerosBySwap(int arr[], int n)
    {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                // Swap
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                j++;
            }
        }
    }
}

// The Both approaches can be used for Sorting 0 and 1