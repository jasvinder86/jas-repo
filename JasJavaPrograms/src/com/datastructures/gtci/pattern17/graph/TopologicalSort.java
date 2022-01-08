package com.datastructures.gtci.pattern17.graph;

import java.util.*;

public class TopologicalSort {

    public static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();

//        1. Data structures needed are:
//        a map of in-degrees (vertex, in-degree),
//        a map to represent the graph (vertex, list<children>)


        Map<Integer, Integer> inDegreeMap = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

//        2. Initialize the inDegreeMap to contain 0 for all vertices at the beginning
        for (int i = 0; i < vertices; i++) {

//            Here I've assumed that all the vertices will be as 0 to n where n is the count of the vertices.
            inDegreeMap.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

//        3. Create the graph
        for (int e = 0; e < edges.length; e++) {
//            Parent will be the first node in an edge (u,v). This will be calculated for each edge in the array of edges
            int parent = edges[e][0];

//            Child will be the second node in an edge (u,v). This will be calculated for each edge in the array of edges.
            int child = edges[e][1];

//            add edge for each parent-child
            graph.get(parent).add(child);

//            Increment in-degree for the child in each node
            inDegreeMap.put(child, inDegreeMap.get(child) + 1);

        }

//        4. Insert all the parents i.e. the vertices with inDegree=0 into a Queue
        Queue<Integer> parentsQueue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> eachEntry : inDegreeMap.entrySet()) {
            if (eachEntry.getValue() == 0) {
                parentsQueue.offer(eachEntry.getKey());
            }
        }

//        5. Remove each parent from the queue, add it to the sorted list.
        while (!parentsQueue.isEmpty()) {
            int node = parentsQueue.poll();
            sortedOrder.add(node);

//            6. Reduce the in-degree of children of the parent removed above
            List<Integer> listOfChildren = graph.get(node);
            for (int child : listOfChildren) {
                inDegreeMap.put(child, inDegreeMap.get(child) - 1);

//                7. Since we're currently processing a child node already, add it to the parentsQueue if degree of the child == 0
                if (inDegreeMap.get(child) == 0) {
                    parentsQueue.offer(child);
                }
            }
        }

        if (sortedOrder.size() != vertices)
            return new ArrayList<>();

        return sortedOrder;
    }

    public static void main(String[] args) {
        List<Integer> result = TopologicalSort.sort(4,
                new int[][]{new int[]{3, 2}, new int[]{3, 0}, new int[]{2, 0}, new int[]{2, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(5,
                new int[][]{new int[]{4, 2}, new int[]{4, 3}, new int[]{2, 0}, new int[]{2, 1}, new int[]{3, 1}});
        System.out.println(result);

        result = TopologicalSort.sort(7,
                new int[][]{new int[]{5, 4}, new int[]{5, 3}, new int[]{6, 4}, new int[]{6, 2}, new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2}
                        , new int[]{4, 1}});
        System.out.println(result);

//        this input contains a cycle due to which all its children's degree won't reduce to 0, so they won't be added to the queue, due to which
//        the queue will get empty prematurely and the sorted list will have lesser nodes than the count of vertices. Hence, it'll result in an empty list.

        result = TopologicalSort.sort(7,
                new int[][]{new int[]{5, 4}, new int[]{5, 3}, new int[]{6, 4}, new int[]{6, 2}, new int[]{3, 0}, new int[]{3, 1}, new int[]{3, 2},
                        new int[]{4, 1}, new int[]{1, 2}, new int[]{2, 1}});
        System.out.println(result);

    }
}
