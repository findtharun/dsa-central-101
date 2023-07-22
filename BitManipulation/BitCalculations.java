package BitManipulation;

public class BitCalculations {
    void countAllSetBits(int n){
        int count =0;
        while(n>0){
            if((n&1)!= 0){
                count++;
            }
            n = n>>1;
        }
        System.out.print("Set Bits Count : " +count);
    }
    public static void main(String[] args){
        BitCalculations obj = new BitCalculations();
        obj.countAllSetBits(10);
    }
    
}
