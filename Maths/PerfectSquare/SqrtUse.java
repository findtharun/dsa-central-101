package Maths.PerfectSquare;

public class SqrtUse {
    public static boolean isPerfectSquare(int x) {
        double b = Math.sqrt(x);
        if ((int) b * (int) b == x)
            return true;
        return false;
    }

    public static void main(String[] args) {
        boolean check = isPerfectSquare(4);
        System.out.println(check);
    }
}
