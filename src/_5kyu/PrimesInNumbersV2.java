package _5kyu;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrimesInNumbersV2 {
    public static String factors(int n) {

        boolean running = true;
        boolean iIsPrime = true;
        int primes = 2;
        ArrayList<Integer> factors = new ArrayList<>();
        while (running) {
            if (n % primes == 0) {
                n /= primes;
                factors.add(primes);
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        iIsPrime = false;
                        break;
                    }
                }
                if (iIsPrime) {
                    factors.add(n);
                    running = false;
                }
                for (int i = primes + 1; i <= n / 2; i++) {
                    iIsPrime = true;
                    for (int j = 2; j <= Math.sqrt(i); j++) {
                        if (i % j == 0) {
                            iIsPrime = false;
                            break;
                        }
                    }
                    if (iIsPrime) {
                        primes = i;
                        break;
                    }

                }
            }
        }

        StringBuilder result = new StringBuilder("(");
        int count = 1;

        for (int i = 0; i < factors.size() - 1; i++) {
            if (factors.get(i + 1) == factors.get(i)) {
                count++;
            } else {
                if (count > 1) {
                    result.append(factors.get(i) + "**" + count + ")(");
                    count = 1;
                } else {
                    result.append(factors.get(i) + ")(");
                }
            }
        }
        result.append(factors.get(factors.size() - 1) + ")");

        return result.toString();
    }

    public static String factors2(int lst) {
        String result = "";
        for (int fac = 2; fac <= lst; ++fac) {
            int count;
            for (count = 0; lst % fac == 0; ++count) {
                lst /= fac;
            }
            if (count > 0) {
                result += "(" + fac + (count > 1 ? "**" + count : "") + ")";
            }
        }
        return result;
    }


    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(factors(7775460));
        System.out.println(factors(18195729));
        System.out.println(factors(52576058));
        long finish = System.nanoTime();
        long timeElapsed = finish - start;
        System.out.println("Time elapsed: " + (double)timeElapsed/1000000000);
    }
}
