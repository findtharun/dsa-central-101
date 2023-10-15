package Searching.BinarySearch;

//https://www.codingninjas.com/studio/problems/square-root-integral_893351
public class SquareRoot {
    public static int sqrtN(long N) {
        long low = 1;
        long high = N;
        int res = (int) high;
        while (low <= high) {
            long mid = (low + high) / 2;
            long val = mid * mid;
            if (val <= N) {
                low = mid + 1;
                res = (int) mid;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }
}
