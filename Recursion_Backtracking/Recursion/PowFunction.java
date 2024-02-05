public class PowFunction {
    public double helper(double x, long n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;

        double res = helper(x * x, n / 2);
        return n % 2 == 1 ? x * res : res; // Handling Odd and Even Powers
    }

    public double myPow(double x, int n) {
        // x^-n = 1/x^n and Handling Negative Powers at the End
        if (n == 0)
            return 1;
        // We have to Convert to Long for the Value of n = -2147483648, Since Absolute
        // Value of it would be out of Range for Int
        double res = helper(x, Math.abs((long) n));
        return n >= 0 ? res : 1 / res;
    }
}
