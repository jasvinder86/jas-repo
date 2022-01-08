package com.datastructures.gtci.pattern17.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AdjacencyListOfUndirectedGraph {

    int V;  // vertices
    int E;  // edges
    LinkedList<Integer>[] adjacencyList;

    public AdjacencyListOfUndirectedGraph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adjacencyList = new LinkedList[nodes];
        for (int v = 0; v < V; v++) {
            adjacencyList[v] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v) {
        adjacencyList[v].add(u);
        adjacencyList[u].add(v);
        E++;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This graph has " + V + " vertices and " + E + " edges \n");
        for (int v = 0; v < V; v++) {
            sb.append(v + " : ");
            for (int w : adjacencyList[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //    source is the integer where we start the traversal from
    public void breadthFirstSearch(int source) {
        System.out.print("\nBFS form is >> ");
//        Maintain an array of all the vertices. This array will let us know if a vertex has been traversed or not.
        boolean[] isNodeVisited = new boolean[V];

//        Maintain a queue for each traversed node.
        Queue<Integer> queue = new LinkedList<>();
        isNodeVisited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");

//        Now traverse each node connected to the current node
            for (int v : adjacencyList[u]) {
                if (!isNodeVisited[v]) {
                    isNodeVisited[v] = true;
                    queue.offer(v);
                }
            }
        }
        System.out.println("");
    }

    //    Use a stack for the iterative depth first search implementation
    public void iterativeDepthFirstSearch(int source) {
        System.out.print("Iterative Depth First Search >> ");

//        Maintain an array of the visited nodes, size = no. of nodes
        boolean[] isNodeVisited = new boolean[V];

//        Keep pushing nodes to a stack for DFS implementation
        Stack<Integer> stack = new Stack<>();

        stack.push(source);
        isNodeVisited[source] = true;

        while (!stack.isEmpty()) {
//            Each node pushed into the stack will have its own adjacency list which will be traversed now.
            int u = stack.pop();
            System.out.print(u + " ");

//            Now traverse over each node in the adj list of this node
            for (int v : adjacencyList[u]) {
                if (!isNodeVisited[v]) {
                    isNodeVisited[v] = true;
                    stack.push(v);
                }
//                True - 0 1 3 2 4
//                Stack -
//                u : 1
//                console - 0 3 2 4 1
            }
        }

    }

    public void recursiveDepthFirstSearch() {
        System.out.print("\nRecursive Depth First Search >> ");
        boolean[] isNodeVisited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!isNodeVisited[i]) {
                recursivelyTraverseDFS(i, isNodeVisited);
            }
        }
    }

    private void recursivelyTraverseDFS(int v, boolean[] isNodeVisited) {
        if (!isNodeVisited[v]) {
            isNodeVisited[v] = true;
            System.out.print(v + " ");

//            Traverse each node in the list against the current node
            for (int w : adjacencyList[v]) {
                recursivelyTraverseDFS(w, isNodeVisited);
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyListOfUndirectedGraph graph = new AdjacencyListOfUndirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);
        System.out.println(graph);
        graph.breadthFirstSearch(0);
        graph.iterativeDepthFirstSearch(0);
        graph.recursiveDepthFirstSearch();

        System.out.println();
        AdjacencyListOfUndirectedGraph graph1 = new AdjacencyListOfUndirectedGraph(5);
        graph1.addEdge(0, 1);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 0);
        graph1.addEdge(2, 4);
        System.out.println(graph1);
        graph1.breadthFirstSearch(0);
        graph1.iterativeDepthFirstSearch(0);
        graph1.recursiveDepthFirstSearch();
    }

}
