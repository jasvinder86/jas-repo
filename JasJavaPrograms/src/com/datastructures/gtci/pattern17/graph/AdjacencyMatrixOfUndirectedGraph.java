package com.datastructures.gtci.pattern17.graph;

public class AdjacencyMatrixOfUndirectedGraph {

    int V;  // vertices
    int E;  // edges
    int[][] adjacencyMatrix;

    //    Create a matrix of nodes X nodes
    public AdjacencyMatrixOfUndirectedGraph(int nodes) {
        this.V = nodes;
        this.E = 0;
        adjacencyMatrix = new int[nodes][nodes];
    }

    public void addNewEdge(int u, int v) {
        adjacencyMatrix[u][v] = 1;
        adjacencyMatrix[v][u] = 1;
        E++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This graph has " + V + " vertices and " + E + " edges\n");

//        iterate over the vertices
        for (int v = 0; v < V; v++) {
            sb.append(v + " : ");

//            iterate the array against the current vertex
            for (int w : adjacencyMatrix[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AdjacencyMatrixOfUndirectedGraph graph = new AdjacencyMatrixOfUndirectedGraph(4);
        graph.addNewEdge(0, 1);
        graph.addNewEdge(0, 3);
        graph.addNewEdge(1, 2);
        graph.addNewEdge(2, 3);
        System.out.println(graph);
    }

}
