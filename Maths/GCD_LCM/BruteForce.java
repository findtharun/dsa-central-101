package Maths.GCD_LCM;

public class BruteForce {
    public int GCD(int a, int b) {
        int x = Math.min(a, b);
        while (x > 0) {
            if (a % x == 0 && b % x == 0) {
                break;
            }
            x--;
        }
        return x;
    }

    public static void main(String[] args) {
        BruteForce gcdObj = new BruteForce();
        int res = gcdObj.GCD(28, 54);
        System.out.print(res);
    }
}