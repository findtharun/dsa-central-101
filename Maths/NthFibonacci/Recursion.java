package Maths.NthFibonacci;

public class Recursion {

    int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int res = 0;
        Recursion obj = new Recursion();
        res = obj.Fibonacci(7);
        System.out.println(res);

    }
}
