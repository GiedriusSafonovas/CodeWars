package _6kyu;

import java.util.ArrayList;
import java.util.Arrays;

public class IsANumberPrime {
    public static boolean isPrime(int num) {
        boolean prime = true;
        int count = 0;

        ArrayList<Integer> primeList = new ArrayList<>();
        if(num<2) return false;
        if(num == 2) return true;
        if(num%2 == 0) return false;
        primeList.add(2);
        for (int i = 3; i <= Math.sqrt(num); i++) {
            prime = true;
            for (int j = 0; j < primeList.size(); j++) {
                count++;
                if(i% primeList.get(j) == 0){
                    prime = false;
                    break;
                }
            }
            if(prime){
                if(num%i == 0) {
                    System.out.println(count);
                    return false;
                }
                primeList.add(i);
            }
        }
        System.out.println(count);
        return true;

//        if(num < 2)
//            return false;
//        for (int i=2; i<=Math.sqrt(num); i++){
//            count++;
//            if(num % i == 0) {
//                System.out.println(count);
//                return false;
//            }
//        }
//        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(1391812249));
//        System.out.println(isPrime(4));
//        System.out.println(isPrime(-1));
    }
}
