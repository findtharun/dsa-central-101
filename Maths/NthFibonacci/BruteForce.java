package Maths.NthFibonacci;

public class BruteForce {

   int getNthFibonacci(int n){
        int a=0; //Oth Fibonacci
        int b=1; //1st Fibonacci
        int c =-1; // Some Random Initialization
        for(int i=2;i<=n;i++){
            c = a+b;
            a = b;
            b = c;
        }
        return b;
    }
    public static void main(String[] args){
       BruteForce obj = new BruteForce();
       int res  = obj.getNthFibonacci(7);
       System.out.println(res);
    }
}
