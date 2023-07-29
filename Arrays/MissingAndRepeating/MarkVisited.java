package Arrays.MissingAndRepeating;

public class MarkVisited {
    int[] findMissingAndRepeated(int arr[], int n) {
            int[] res = new int[2];
            for(int i=0;i<n;i++){
                int abs_val = Math.abs(arr[i]);
                if(arr[abs_val-1]>0){
                    arr[abs_val -1] = - arr[abs_val-1]; // MArking as Visited by Making it Negative
                }else{
                    res[0] = abs_val; // Repeated Number
                }
            }
             for(int i=0;i<n;i++){
                if(arr[i]>0){
                    res[1]= i+1; // Missing Number
                }
             }

            return res;
    }

    public static void main(String[] args) {
        int arr[] = { 7, 3, 4, 5, 5, 6, 2 };
        int n = arr.length;
        MarkVisited markVisited = new MarkVisited();
        int[] ans = markVisited.findMissingAndRepeated(arr, n);
        for (int ele : ans) {
            System.out.print(ele + " ");
        }
    }
}
