package BitManipulation;

public class BitMasking {
    // Get Ith Index Bit (Since Index Start from O)
    public int getIthIndexBit(int i, int n) {
        if ((n & (1<<i)) == 0)
            return 0;
        else
            return 1;
    }

    // set Ith Position Bit
    public int setIthIndexBit(int i, int n) {
        return (n | (1<<i));
    }

    // clear Ith Poistion Bit
    public int clearIthIndexBit(int i, int n) {
        return (n & ~(1<<i));
    }

    public static void main(String[] args) {
        int n = 7;
        int i = 2;
        BitMasking obj = new BitMasking();
        System.out.println(obj.getIthIndexBit(i,n));
    }
}
