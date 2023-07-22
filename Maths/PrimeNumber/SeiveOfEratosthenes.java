package Maths.PrimeNumber;

import java.util.*;

public class SeiveOfEratosthenes {
    void findPrimesLessThan(int n) {
        boolean[] markedPrime = new boolean[n + 1];
        Arrays.fill(markedPrime, true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (markedPrime[i] == true) {
                for (int j = i * i; j <= n; j = j + i) {
                    markedPrime[j] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (markedPrime[i])
                System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {
        SeiveOfEratosthenes obj = new SeiveOfEratosthenes();
        obj.findPrimesLessThan(10);
    }

}
