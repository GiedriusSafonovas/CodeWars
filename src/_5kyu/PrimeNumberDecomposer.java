package _5kyu;

//You have to code a function getAllPrimeFactors wich take an integer as parameter and return an array containing its prime decomposition by ascending factors, if a factors appears multiple time in the decomposition it should appear as many time in the array.
//
//        exemple: getAllPrimeFactors(100) returns [2,2,5,5] in this order.
//
//        This decomposition may not be the most practical.
//
//        You should also write getUniquePrimeFactorsWithCount, a function which will return an array containing two arrays: one with prime numbers appearing in the decomposition and the other containing their respective power.
//
//        exemple: getUniquePrimeFactorsWithCount(100) returns [[2,5],[2,2]]
//
//        You should also write getPrimeFactorPotencies an array containing the prime factors to their respective powers.
//
//        exemple: getPrimeFactorPotencies(100) returns [4,25]
//
//        Errors, if:
//
//        n is not a number
//        n not an integer
//        n is negative or 0
//
//        The three functions should respectively return [], [[],[]] and [].
//
//        Edge cases:
//
//        if n=0, the function should respectively return [], [[],[]] and [].
//        if n=1, the function should respectively return [1], [[1],[1]], [1].
//        if n=2, the function should respectively return [2], [[2],[1]], [2].
//
//        The result for n=2 is normal. The result for n=1 is arbitrary and has been chosen to return a usefull result. The result for n=0 is also arbitrary but can not be chosen to be both usefull and intuitive. ([[0],[0]] would be meaningfull but wont work for general use of decomposition, [[0],[1]] would work but is not intuitive.)


import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumberDecomposer {
    /**
     Return value: List of all prime factors of a given number n
     */
    public static Long[] getAllPrimeFactors(long n) {
        if(n <= 0){
            return new Long[] {};
        }
        if(n == 1L){
            return  new Long[] {1L};
        }
        if(n==2L){
            return new Long[] {2L};
        }

        ArrayList<Long> factorList = new ArrayList<>();
        long i = 2L;
        while(i < n){
            if(n%i ==0){
                factorList.add(i);
                n /= i;
                i = 2L;
            }else{
                i++;
            }
        }
        factorList.add(n);
        Long[] result = new Long[factorList.size()];

        for (int j = 0; j < factorList.size(); j++) {
            result[j] = factorList.get(j);
        }
        return result;
    }
    /**
     Return value: List containing two lists, first containg all prime factors without duplicates,
     second containing the count, how often each prime factor occured.
     Return code always contains two lists.

     e.g.: getUniquePrimeFactorsWithCount(100) = {{2,5},{2,2}) // prime 2 occurs 2 times, prime 2 occurs 5 times,
     */
    public static Long[][] getUniquePrimeFactorsWithCount(long n) {
        if(n <= 0){
            return new Long[][] {{},{}};
        }
        if(n == 1L){
            return  new Long[][] {{1L},{1L}};
        }
        if(n==2L){
            return new Long[][] {{2L},{1L}};
        }

        Long[] factors = getAllPrimeFactors(n);
        ArrayList<Long> factorList= new ArrayList<>();
        ArrayList<Long> countList = new ArrayList<>();
        long count = 1;
        factorList.add(factors[0]);
        for (int i = 0; i < factors.length - 1; i++) {
            if(factors[i] == factors[i+1]){
                count ++;
            }else{
                countList.add(count);
                count = 1;
                factorList.add(factors[i+1]);
            }
        }
        countList.add(count);
        Long[][] result = new Long[2][factorList.size()];
        for (int i = 0; i < factorList.size(); i++) {
            result[0][i] = factorList.get(i);
            result[1][i] = countList.get(i);
        }

        return result;
    }
    /**
     Return value: List containing product of same prime factors,
     e.g.: 45 = 3*3*5 ==>  {3^2,5^1} == {9,5}
     e.g.: getUniquePrimeFactorsWithCount(100) = {{2,5},{2,2}) // prime 2 occurs 2 times, prime 2 occurs 5 times,
     */
    public static Long[] getPrimeFactorPotencies(long n) {
        if(n <= 0){
            return new Long[] {};
        }
        if(n == 1L){
            return  new Long[] {1L};
        }
        if(n==2L){
            return new Long[] {2L};
        }
        Long[][] data = getUniquePrimeFactorsWithCount(n);
        Long[] result = new Long[data.length];
        for (int i = 0; i < data.length; i++) {
            long potency = 1;
            for (int j = 0; j < data[1][i]; j++) {
                potency = potency*data[0][i];
            }
            result[i] = potency;
        }
        return result;
    }

    public static void main(String[] args) {
        long number = 1000;
        System.out.println(Arrays.toString(getAllPrimeFactors(number)));
        Long[][] t = getUniquePrimeFactorsWithCount(number);
        for (int i = 0; i < t.length; i++) {
            System.out.println(Arrays.toString(t[i]));
        }
        System.out.println(Arrays.toString(getPrimeFactorPotencies(number)));
    }
}
