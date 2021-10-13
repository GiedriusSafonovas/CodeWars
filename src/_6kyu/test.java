package _6kyu;

public class test {
    public static void main(String[] args) {
        int x = 1234;

        for (int i = 0; i < 11; i++) {
            System.out.print((x & 1));
            x = x >> 1;
        }
        //10011010010
        //00000000001
    }
}
