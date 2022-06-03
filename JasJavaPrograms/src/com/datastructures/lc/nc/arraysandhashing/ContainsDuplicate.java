package com.datastructures.lc.nc.arraysandhashing;

import java.util.Set;
import java.util.TreeSet;

/* Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 */

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new TreeSet();

        for (int i : nums) {
            if (set.contains(i))
                return true;

            else
                set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 4}));     // expected = false
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1, 2, 3, 1}));     // expected = true
    }

}
