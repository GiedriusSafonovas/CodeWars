package _6kyu;

public class BitCounting {
    public static int countBits(int n){
        int count = 0;
        while(n>0){
            count += n & 1;
            n >>= 1;
        }
        return count;

        //return Integer.bitCount(n);
    }


    public static void main(String[] args) {
        System.out.println(countBits(1234));
    }
}
