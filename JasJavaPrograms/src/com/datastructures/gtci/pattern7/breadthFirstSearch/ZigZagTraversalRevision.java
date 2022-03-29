package com.datastructures.gtci.pattern7.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ZTreeNode {
    int data;
    ZTreeNode left;
    ZTreeNode right;

    public ZTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class ZigZagTraversalRevision {


    public List<List<Integer>> traverse(ZTreeNode root) {

        List<List<Integer>> outputList = new ArrayList<>();

        Queue<ZTreeNode> nodeQueue = new LinkedList<ZTreeNode>();
        nodeQueue.offer(root);
        int level = 0;

        while (!nodeQueue.isEmpty()) {
            List<Integer> nodeList = new LinkedList<Integer>();

            int queueSize = nodeQueue.size();

            for (int i = 0; i < queueSize; i++) {

                ZTreeNode currentNode = nodeQueue.poll();
                if (level % 2 == 0)
                    nodeList.add(currentNode.data);
                else
                    nodeList.add(0, currentNode.data);

                if (currentNode.left != null)
                    nodeQueue.offer(currentNode.left);
                if (currentNode.right != null)
                    nodeQueue.offer(currentNode.right);
            }
            level++;
            outputList.add(nodeList);
        }

        return outputList;
    }

    public static void main(String[] args) {
        ZigZagTraversalRevision zigZagTraversalRevision = new ZigZagTraversalRevision();
        ZTreeNode root = new ZTreeNode(1);

        root.left = new ZTreeNode(2);
        root.right = new ZTreeNode(3);

        root.left.left = new ZTreeNode(4);
        root.left.right = new ZTreeNode(5);

        root.right.left = new ZTreeNode(6);
        root.right.right = new ZTreeNode(7);

        List<List<Integer>> result = zigZagTraversalRevision.traverse(root);
        System.out.println("Output list is : " + result);


    }


}
