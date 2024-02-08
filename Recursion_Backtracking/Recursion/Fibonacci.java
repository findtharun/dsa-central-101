// The Below Snippets Explain about Tail and Non Tail Implementation, Tail Recusion is Optimized version.
public class Fibonacci {
    public int tail(int n, int a, int b) {

        if (n == 0)
            return a;
        if (n == 1)
            return b;

        return tail(n - 1, b, a + b);
    }

    public int nonTail(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return nonTail(n - 1) + nonTail(n - 2);
    }
}
