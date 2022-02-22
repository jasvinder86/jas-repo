package com.datastructures.gtci.pattern4.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval2 {
    int start;
    int end;

    public Interval2(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

/*
 * Insert Interval
 * Given a list of non-overlapping intervals sorted by their start time,
 * insert a given interval at the correct position and
 * merge all necessary intervals to produce a list that has only mutually exclusive intervals.
 */
public class InsertIntervalRev {

    public static List<Interval2> insert(List<Interval2> intervals, Interval2 newInterval) {
        List<Interval2> mergedIntervals = new ArrayList<>();

        if (intervals == null || intervals.isEmpty())
            return Arrays.asList(newInterval);


//        1. Traverse till the length of the list of intervals.
        int listSize = intervals.size();

        int i = 0;

//        2. Traverse till the new interval's start < current interval's end since till then there's no overlap.
        while (i < listSize && newInterval.start > intervals.get(i).end) {
            mergedIntervals.add(new Interval2(intervals.get(i).start, intervals.get(i).end));
            i++;
        }

//        3. Now the new interval's start is < current interval's end, so merge them if possible to merge
//        if e.g. new = [4,6] and current = [8,10] => can't merge them
//        if e.g. new = [4,6] and current = [5,7] => will be merged
        while (i < listSize && newInterval.end >= intervals.get(i).start) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        mergedIntervals.add(newInterval);

//        4. Check is still there are any elements left in this list of intervals
        while (i < listSize) {
            mergedIntervals.add(new Interval2(intervals.get(i).start, intervals.get(i).end));
            i++;
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval2> input = new ArrayList<Interval2>();
        input.add(new Interval2(1, 3));
        input.add(new Interval2(5, 7));
        input.add(new Interval2(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval2 interval : InsertIntervalRev.insert(input, new Interval2(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval2>();
        input.add(new Interval2(1, 3));
        input.add(new Interval2(5, 7));
        input.add(new Interval2(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval2 interval : InsertIntervalRev.insert(input, new Interval2(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval2>();
        input.add(new Interval2(2, 3));
        input.add(new Interval2(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval2 interval : InsertIntervalRev.insert(input, new Interval2(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

}
