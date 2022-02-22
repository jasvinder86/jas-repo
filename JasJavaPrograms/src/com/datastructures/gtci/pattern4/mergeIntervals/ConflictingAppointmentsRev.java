package com.datastructures.gtci.pattern4.mergeIntervals;

/*
 * Conflicting Appointments
 * Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
 * */


import java.util.Arrays;

class Interval_1 {
    int start;
    int end;

    public Interval_1(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

public class ConflictingAppointmentsRev {

    public static boolean canAttendAllAppointments(Interval_1[] intervals) {
        // TODO: Write your code here


        Arrays.sort(intervals,
                (a, b) -> Integer.compare(a.start, b.start)
        );

        int i = 0, noOfAppointments = intervals.length;

        if (noOfAppointments <= 1)
            return true;

        while (i + 1 < noOfAppointments) {
            if (intervals[i + 1].start < intervals[i].end)
                return false;

            i++;
        }

        return true;
    }

}
