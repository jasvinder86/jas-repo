package com.datastructures.gtci.pattern7.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

class MTreeNode {
    int value;
    MTreeNode left, right;

    MTreeNode(int data) {
        this.value = data;
    }
}

public class MinimumTreeDepthRev {

    public static int getMinTreeDepth(MTreeNode root) {
        int minDepth = 1;

        if (root == null) {
            return 0;
        } else {
            Queue<MTreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                int currentQueueSize = queue.size();
                for (int i = 0; i < currentQueueSize; i++) {
                    MTreeNode currentNode = queue.poll();

                    if (currentNode.left == null && currentNode.right == null)
                        return minDepth;

                    else {
                        if (currentNode.left != null)
                            queue.offer(currentNode.left);

                        if (currentNode.right != null)
                            queue.offer(currentNode.right);
                    }
                }
                minDepth++;
            }
            return minDepth;
        }
    }

    public static void main(String[] args) {
        MTreeNode root = new MTreeNode(12);

        root.left = new MTreeNode(7);
        root.right = new MTreeNode(1);

        root.right.left = new MTreeNode(10);
        root.right.right = new MTreeNode(5);
        System.out.println("Minimum Depth : " + MinimumTreeDepthRev.getMinTreeDepth(root));

        root.left.left = new MTreeNode(9);
        root.right.left.left = new MTreeNode(11);
        System.out.println("Minimum Depth : " + MinimumTreeDepthRev.getMinTreeDepth(root));
    }
}