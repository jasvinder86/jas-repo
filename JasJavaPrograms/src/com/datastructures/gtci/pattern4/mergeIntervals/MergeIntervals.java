package com.datastructures.gtci.pattern4.mergeIntervals;

import java.util.*;

/*
Problem Statement
        Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
*/


class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {

        if (intervals.size() <= 1) {
            return intervals;
        }

        List<Interval> mergedIntervals = new LinkedList<Interval>();
//        1. Sort all the intervals based on their start values
        Collections.sort(intervals, (input1, input2) -> Integer.compare(input1.start, input2.start));

//        2. Get the first interval and initialize the start and end values.
        Iterator<Interval> iterator = intervals.iterator();
        Interval firstInterval = iterator.next();
        int start = firstInterval.start;
        int end = firstInterval.end;

        while (iterator.hasNext()) {
            Interval currentInterval = iterator.next();

            if (currentInterval.start < end) {
//               3. This means that there is an overlap between the first and the current interval
                end = Math.max(end, currentInterval.end);

            } else {
//                4. if there 's no overlap, simply add the interval to the final list to return.
                mergedIntervals.add(new Interval(start, end));

//                5. update the start and end with the current interval's values
                start = currentInterval.start;
                end = currentInterval.end;
            }
        }

//        6. Finally, add the last interval into the list.
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(7, 9));
        input.add(new Interval(2, 5));
        input.add(new Interval(1, 4));

        System.out.println("Merged Intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.println("Merged Intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.println("Merged Intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }


}
