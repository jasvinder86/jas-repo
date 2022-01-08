package com.datastructures.gtci.pattern17.graph;

/*
Problem Statement
        There are ‘N’ tasks, labeled from ‘0’ to ‘N-1’. Each task can have some prerequisite tasks
        which need to be completed before it can be scheduled. Given the number of tasks and a list of
        prerequisite pairs, find out if it is possible to schedule all the tasks.
*/

import java.util.*;

public class TasksScheduling {
    public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {

//        Scheduling is possible if there is no cyclic dependency of tasks on each other. Let's perform a topological sort on the given input
//        and see if a cyclic dependency exists or not.

//        1. Convert the array of prerequisites  into a graph to have an adjacency list.
        Map<Integer, List<Integer>> graph = new HashMap<>();

//        2. Make a map of in-degree of each task to know its dependency on other tasks
        Map<Integer, Integer> taskDependencyMap = new HashMap<>();

        for (int t = 0; t < tasks; t++) {
//            initialize each task with 0 dependency
            taskDependencyMap.put(t, 0);

//            initialize each task with an arrayList of dependent tasks
            graph.put(t, new ArrayList<>());
        }

//        3. Traverse over the array of prerequisites and update each parent and its children in the graph
        for (int p = 0; p < prerequisites.length; p++) {
            int parent = prerequisites[p][0];
            int child = prerequisites[p][1];

//            Each child will get mapped to its parent by the below
            graph.get(parent).add(child);

//            Each child's in-degree will get updated by the below
            taskDependencyMap.put(child, taskDependencyMap.get(child) + 1);
        }

//            4. Put all the current parent tasks in a queue
        Queue<Integer> queueOfParentTask = new LinkedList<>();
        for (Map.Entry<Integer, Integer> eachTask : taskDependencyMap.entrySet()) {
            if (eachTask.getValue() == 0)
                queueOfParentTask.offer(eachTask.getKey());
        }

//            5. Traverse over the queue and the current parent tasks in the final list of tasks
        List<Integer> allTaskList = new ArrayList<>();
        while (!queueOfParentTask.isEmpty()) {
            int currentTask = queueOfParentTask.poll();
            allTaskList.add(currentTask);

            for (int childTask : graph.get(currentTask)) {
                taskDependencyMap.put(childTask, taskDependencyMap.get(childTask) - 1);

//                    If the child task doesn't have any dependency now, add it to the queue of parents
                if (taskDependencyMap.get(childTask) == 0)
                    queueOfParentTask.offer(childTask);
            }

        }

//            6. If count of all the tasks ==  the size of the allTaskList, it means all the tasks can be executed.
        System.out.println("list size is " + allTaskList.size() + " and the list is " + allTaskList);
        if (allTaskList.size() == tasks) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        boolean result = TasksScheduling.isSchedulingPossible(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}});
        System.out.println("Tasks execution possible : " + result);

        result = TasksScheduling.isSchedulingPossible(3, new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}});
        System.out.println("Tasks execution possible : " + result);

        result = TasksScheduling.isSchedulingPossible(6, new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4},
                new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}});
        System.out.println("Tasks execution possible : " + result);

        result = TasksScheduling.isSchedulingPossible(6, new int[][]{new int[]{2, 5}, new int[]{0, 5}, new int[]{0, 4},
                new int[]{1, 4}, new int[]{3, 2}, new int[]{1, 3}, new int[]{3, 1}});
        System.out.println("Tasks execution possible : " + result);
    }
}