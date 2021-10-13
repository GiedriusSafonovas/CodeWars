package _4kyu;

//Write a function called sumIntervals/sum_intervals() that accepts an array of intervals, and returns the sum of all the interval lengths. Overlapping intervals should only be counted once.
//        Intervals
//
//        Intervals are represented by a pair of integers in the form of an array. The first value of the interval will always be less than the second value. Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.
//        Overlapping Intervals
//
//        List containing overlapping intervals:
//
//        [
//        [1,4],
//        [7, 10],
//        [3, 5]
//        ]
//
//        The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which has a length of 4.
//        Examples:
//
//// null argument
//        Interval.sumIntervals(null);  // => 0
//
//// empty intervals
//        Interval.sumIntervals(new int[][]{});  // => 0
//        Interval.sumIntervals(new int[][]{2,2}, {5,5});  // => 0
//
//// disjoined intervals
//        Interval.sumIntervals(new int[][]{
//        {1,2},{3,5}
//        });  // => (2-1) + (5-3) = 3
//
//// overlapping intervals
//        Interval.sumIntervals(new int[][]{
//        {1,4},{3,6},{2,8}
//        });  // [1,8] => 7


import java.util.ArrayList;

public class SumOfIntervals {
    public static int sumIntervals(int[][] intervals) {
        if (intervals == null) {
            return 0;
        }

        intervals = sortArray(intervals);
        ArrayList<int[]> mergedList;
        mergedList = getMergedList(intervals);
        int sum = 0;
        for (int i = 0; i < mergedList.size(); i++) {
            sum += mergedList.get(i)[mergedList.get(i).length - 1] - mergedList.get(i)[0];
        }
        return sum;
    }

    private static int[][] sortArray(int[][] intervals) {
        int[] temp;
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] == intervals[j][0]) {
                    if (intervals[i][1] > intervals[j][1]) {
                        temp = intervals[j];
                        intervals[j] = intervals[i];
                        intervals[i] = temp;
                    }
                } else if (intervals[i][0] > intervals[j][0]) {
                    temp = intervals[j];
                    intervals[j] = intervals[i];
                    intervals[i] = temp;
                }
            }
        }
        return intervals;
    }

    private static ArrayList<int[]> getMergedList(int[][] intervals) {
        ArrayList<int[]> mergedList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                mergedList.add(intervals[i]);
            } else {
                boolean merged = false;
                for (int j = 0; j < mergedList.size(); j++) {
                    int firstElementOfMergedArray = mergedList.get(j)[0];
                    int lastElementOfMergedArray = mergedList.get(j)[1];
                    int firstElementOfIntervalsArray = intervals[i][0];
                    int lastElementOfIntervalsArray = intervals[i][1];
                    if ((firstElementOfIntervalsArray >= firstElementOfMergedArray) && (firstElementOfIntervalsArray <= lastElementOfMergedArray)) {
                        mergedList = mergeIntervals(mergedList, j, firstElementOfMergedArray, lastElementOfIntervalsArray,
                                lastElementOfMergedArray, lastElementOfIntervalsArray);
                        merged = true;
                        break;
                    } else if (lastElementOfIntervalsArray >= firstElementOfMergedArray && lastElementOfIntervalsArray <= lastElementOfMergedArray) {
                        mergedList = mergeIntervals(mergedList, j, firstElementOfIntervalsArray, lastElementOfMergedArray,
                                lastElementOfMergedArray, lastElementOfIntervalsArray);
                        merged = true;
                        break;
                    }
                }
                if (!merged) {
                    mergedList.add(intervals[i]);
                }
            }
        }
        return mergedList;
    }

    private static ArrayList<int[]> mergeIntervals(ArrayList<int[]> mergedList, int index, int startElement, int endElement,
                                                   int lastElementOfMergedArray, int lastElementOfIntervalsArray) {
        if (lastElementOfIntervalsArray < lastElementOfMergedArray) {
            return mergedList;
        }
        mergedList.set(index, new int[]{startElement, endElement});
        return mergedList;
    }


    public static void main(String[] args) {
//        System.out.println(sumIntervals(new int[][]{
//                {1,4},{3,6},{2,8}
//        }));
//
//        System.out.println(sumIntervals(new int[][]{
//                {1, 4}, {7, 10}, {3, 5}
//        }));
//
//        System.out.println(sumIntervals(new int[][]{
//                {5, 8}, {3, 6}, {1, 2}
//        }));

        System.out.println(sumIntervals(new int[][]{
                {1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}
        }));

    }
}
