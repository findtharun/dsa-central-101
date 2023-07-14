package Maths.GCD;
public class BruteForceApproach {
    public int GCD(int a,int b){
        int x = Math.min(a,b);
        while(x>0){
            if(a%x== 0 && b%x ==0){
                break;
            }
            x--;
        }
        return x;
    }
    public static void main(String[] args) {
        BruteForceApproach gcdObj = new BruteForceApproach();
        int res = gcdObj.GCD(28, 54);
        System.out.print(res);
    }
}