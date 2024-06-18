package Sorting.MergeSortedArrays.Merge2SortedArrays;

public class InsertionSimulation {
    /**
     * Time Complexity: O(M * N)
     * Auxiliary Space: O(1)
     */
    static void merge(int arr1[], int arr2[], int n, int m) {
        // two pointer to iterate
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            // if arr1[i] <= arr2[j] then both array is
            // already sorted
            if (arr1[i] <= arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                // if arr1[i]>arr2[j] then first we swap both element so that arr1[i] become
                // smaller means arr1[] become sorted the we check that arr2[j] is smaller than
                // all other element in right side of arr2[j] if
                // arr2[] is not sorted then we linearly do
                // sorting means while adjacent element are
                // less than new arr2[j] we do sorting like
                // by changing position of element by
                // shifting one position toward left
                int t = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = t;
                i++;
                if (j < m - 1 && arr2[j + 1] < arr2[j]) {
                    int temp = arr2[j];
                    int tempj = j + 1;
                    while (tempj < m && arr2[tempj] < temp) {
                        arr2[tempj - 1] = arr2[tempj];
                        tempj++;
                    }
                    arr2[tempj - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int ar1[] = { 1, 5, 9, 10, 15, 20 };
        int ar2[] = { 2, 3, 8, 13 };
        int n = ar1.length;
        int m = ar2.length;
        merge(ar1, ar2, n, m);

        System.out.print("After Merging \nFirst Array: ");
        for (int i = 0; i < n; i++)
            System.out.print(ar1[i] + " ");
        System.out.print("\nSecond Array: ");
        for (int i = 0; i < m; i++)
            System.out.print(ar2[i] + " ");
    }
}
