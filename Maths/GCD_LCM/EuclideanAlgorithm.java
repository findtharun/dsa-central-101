package Maths.GCD_LCM;

public class EuclideanAlgorithm {
    public int GCD(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b; // GCD(b,0) = a
        } else
            return a;
    }

    public static void main(String[] args) {
        EuclideanAlgorithm gcdObj = new EuclideanAlgorithm();
        int res = gcdObj.GCD(28, 54);
        System.out.print(res);
    }
}