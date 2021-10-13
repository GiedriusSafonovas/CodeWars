package _7kyu;

public class GrowthOfaPopulation {
    public static int nbYear(int p0, double percent, int aug, int p) {
        int n = 0;
        while(p0<p){
            p0 = p0 + (int)(p0 * percent/100) + aug;
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(nbYear(1500, 5, 100, 5000));
        System.out.println(nbYear(1500000, 2.5, 10000, 2000000));
    }
}
