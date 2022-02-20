package com.datastructures.gtci.pattern4.mergeIntervals;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Interval1 {
    int start;
    int end;

    public Interval1(int start, int end) {
        this.start = start;
        this.end = end;
    }

}

public class MergeIntervalsRev {

    public static List<Interval1> merge(List<Interval1> intervals) {

        if (intervals.size() < 2)
            return intervals;

        Collections.sort(intervals,
                (i, j) ->
                        Integer.compare(i.start, j.start));

        List<Interval1> mergedIntervals = new LinkedList<Interval1>();
        Iterator<Interval1> iterator = intervals.iterator();
        Interval1 firstInterval = iterator.next();
        int start = firstInterval.start;
        int end = firstInterval.end;

        while (iterator.hasNext()) {
            Interval1 currentInterval = iterator.next();

            if (currentInterval.start <= end) {
                end = Math.max(end, currentInterval.end);
//                Since this array is already sorted by the start of the interval, we don't need to monitor it
//                start = Math.min(start, currentInterval.start);
            } else {
                mergedIntervals.add(new Interval1(start, end));
                start = currentInterval.start;
                end = currentInterval.end;
            }
        }
        mergedIntervals.add(new Interval1(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval1> inputIntervalList = new LinkedList<Interval1>();
        inputIntervalList.add(new Interval1(1, 4));
        inputIntervalList.add(new Interval1(2, 5));
        inputIntervalList.add(new Interval1(7, 9));

        for (Interval1 interval1 : MergeIntervalsRev.merge(inputIntervalList)) {
            System.out.println("[" + interval1.start + "," + interval1.end + "]");
        }
    }


}
