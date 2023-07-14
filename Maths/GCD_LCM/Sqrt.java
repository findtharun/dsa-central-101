package Maths.GCD_LCM;

public class Sqrt {

    public int GCD(int a, int b) {
        int x = Math.min(a, b);
        x = (int) Math.sqrt(x); // Since Math.Sqrt returns Double
        while (x > 0) {
            if (a % x == 0 && b % x == 0) {
                break;
            }
            x--;
        }
        return x;
    }

    public static void main(String[] args) {
        Sqrt sqrtGcdObj = new Sqrt();
        int res = sqrtGcdObj.GCD(28, 54);
        System.out.print(res);
    }
}
