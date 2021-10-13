package _8kyu;

import java.util.stream.IntStream;

public class SmallestIntegerFinder {
    public static int findSmallestInt(int[] args) {
//        int min = 0;
//        for (int i = 0; i < args.length; i++) {
//            if(i == 0) {
//                min = args[i];
//            }else{
//                if(args[i]<min){
//                    min = args[i];
//                }
//            }
//        }
//        return min;

        return IntStream.of(args).min().getAsInt();
    }

    public static void main(String[] args) {
        int expected = 11;
        System.out.println(SmallestIntegerFinder.findSmallestInt(new int[]{34, 15, 88, 2}));
        System.out.println(SmallestIntegerFinder.findSmallestInt(new int[]{34, -345, -1, 100}));
    }
}


