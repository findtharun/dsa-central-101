package Searching.BinarySearch;

//https://www.codingninjas.com/studio/problems/nth-root-of-m_1062679
public class FindNthRoot {
    public static int NthRoot(int n, int m) {
        // Write your code here.
        int val = (int) Math.round(Math.pow(m, (1.0 / (double) n)));
        if (Math.pow(val, n) == m)
            return val;
        return -1;
    }
}
