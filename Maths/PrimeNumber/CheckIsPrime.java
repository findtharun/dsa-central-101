package Maths.PrimeNumber;

public class CheckIsPrime {

    public boolean isPrime(int n) {
        /*
         * We only need to check up to the square root of num because if num is divisible by
         * any number larger than its square root, 
         * then it must also be divisible by a smaller number, which would have been already checked.
         */
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
