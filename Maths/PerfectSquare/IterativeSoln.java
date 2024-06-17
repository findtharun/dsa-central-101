package Maths.PerfectSquare;

class IterativeSoln {
    public static boolean isPerfectSquare(int b) {
        if (b < 0) {
            return false;
        }
        int sum = 0;
        int i = 1;
        while (sum < b) {
            sum += i;
            i += 2;
        }
        return sum == b;
    }

    public static void main(String[] args) {
        boolean check = isPerfectSquare(5);
        System.out.println(check);
    }
}