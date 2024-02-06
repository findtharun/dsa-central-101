/*
 * https://leetcode.com/problems/count-good-numbers/description/
 */
public class GoodNumbers {
    public int countGoodNumbers(long n) {
        // By Obseravtion, we can say at Even Positions we can fill 0,2,4,6,8 -->5
        // At odd Positions we can fill Primes - 2,3,5,7 --> 4
        long e = (n % 2 == 0 ? (n / 2) : (n / 2) + 1); // If the Number is Odd, There would be 1 Extra Even position,so +1
        long o = n / 2;
        int mod = (int) (1e9 + 7);
        long noe = mypow(5, e) % mod;
        long noo = mypow(4, o) % mod;
        long ans = 1;
        ans = (ans * noe * noo) % mod;
        return (int) (ans);

    }

    public long mypow(long x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        if (n % 2 == 0) {
            return mypow((x * x) % (int) (1e9 + 7), n / 2) % (int) (1e9 + 7);
        }
        return (mypow((x * x) % (int) (1e9 + 7), n / 2) * x) % (int) (1e9 + 7);
    }
}
