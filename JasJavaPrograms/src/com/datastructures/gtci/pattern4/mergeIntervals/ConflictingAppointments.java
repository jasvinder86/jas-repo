package com.datastructures.gtci.pattern4.mergeIntervals;

import java.util.Arrays;
import java.util.Collections;

/*
 * Problem Statement
 * Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
 * */
public class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval[] intervals) {

//        1. Sort the intervals by their start time
        Arrays.sort(intervals, (i, j) -> Integer.compare(i.start, j.start));

//        2. If start of the next appointment is < end of previous appointment, there is a conflict
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Result: " + result);

        Interval[] intervals1 = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Result: " + result);

        Interval[] intervals2 = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
        result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Result: " + result);
    }
}
