package com.datastructures.ae.stacks;

import java.util.*;

public class MinMaxStackProgram {
    // Feel free to add new properties and methods to the class.

    static List<Integer> list = new ArrayList<Integer>();
    static Set<Integer> set = new HashSet<>();

    static class MinMaxStack {
        public int peek() {
            // Write your code here.
            if (getListSize() > 0) {
                return list.get(getListSize() - 1);
            }
            return -1;
        }

        public int pop() {
            // Write your code here.
            int popped = peek();
            list.remove(getListSize() - 1);
            set.remove(set.size() - 1);
            return popped;
        }

        public void push(Integer number) {
            // Write your code here.
            list.add(number);
            set.add(number);
        }

        public int getMin() {
            // Write your code here.
            return -1;
        }

        public int getMax() {
            // Write your code here.
            return -1;
        }

        public int getListSize() {
            return list.size();
        }

        public int getSetSize() {
            return set.size();
        }
    }

    public static void main(String[] args) {
        MinMaxStackProgram minMaxStackProgram;
//        MinMaxStackProgram.MinMaxStack.
//        getMin();
    }
}


