package com.datastructures.gtci.pattern4.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *   Problem Statement
 *      Given a list of non-overlapping intervals sorted by their start time,
 *      insert a given interval at the correct position and merge all necessary
 *      intervals to produce a list that has only mutually exclusive intervals.
 */
public class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.isEmpty())
            return Arrays.asList(newInterval);

        List<Interval> mergedIntervals = new ArrayList<>();
        int i = 0;

//        1. Keep traversing and adding the intervals in the final list till the end of an interval is greater than start of the new interval.
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            mergedIntervals.add(intervals.get(i));
            i++;
        }

//        2. Now take the new interval and compare it with the upcoming interval and merge them accordingly.
        while (i < intervals.size() && intervals.get(i).start < newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);

//        3. Increment 'i' as we've added the interval at i to the merged list.
            i++;
        }
        mergedIntervals.add(newInterval);

//        4. Now add the rest of the intervals in the final list.
        while (i < intervals.size()) {
            mergedIntervals.add(intervals.get(i));
            i++;
        }

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));

        System.out.println("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));

        System.out.println("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));

        System.out.println("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

    }
}
