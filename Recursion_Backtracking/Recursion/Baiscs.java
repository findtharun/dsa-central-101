public class Baiscs {
    //  Parameterized or Tail recursive
    public static void funcParam(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        funcParam(i - 1, sum + i);
    }

    // Function Based Recursive Call / Non Tail Recursive
    public static int func(int n) {
        if (n < 1)
            return 0;
        return n + func(n - 1);
    }

    public static void main(String[] args) {
        // Print Sum of N Numbers
        funcParam(4, 0);
        System.out.println(func(3));
    }
}
