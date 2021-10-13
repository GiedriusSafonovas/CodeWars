package _6kyu;

//Digital root is the recursive sum of all the digits in a number.
//
//        Given n, take the sum of the digits of n. If that value has more than one digit, continue reducing in this way until a single-digit number is produced. The input will be a non-negative integer.
//        Examples
//
//        16  -->  1 + 6 = 7
//        942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
//        132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
//        493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2


public class SumOfDigits {
    public static int digital_root(int n) {
        int sum = 0;
        do {
            while (n>0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
            sum = 0;
        } while((""+n).length() >1);
        return n;
    }

    public static void main(String[] args) {
        System.out.println(digital_root(16));
        System.out.println(digital_root(942));
        System.out.println(digital_root(132189));
        System.out.println(digital_root(493193));
    }
}
