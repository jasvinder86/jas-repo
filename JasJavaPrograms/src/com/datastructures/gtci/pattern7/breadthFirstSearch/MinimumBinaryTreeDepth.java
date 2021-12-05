package com.datastructures.gtci.pattern7.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem Statement:
Find the minimum depth of a binary tree.
The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.
*/

public class MinimumBinaryTreeDepth {

    public static int findDepth(TreeNode root) {

        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);


//        1. If root != null, minimumDepth at the start will be 1 for the root node
        int minimumDepth = 1;
        while (!queue.isEmpty()) {

            int currentLevelSize = queue.size();

            for (int i = 0; i < currentLevelSize; i++) {
                TreeNode currentNode = queue.poll();

//                2. when both the child nodes are null, that is the leaf node
                if (currentNode.left == null && currentNode.right == null)
                    return minimumDepth;

                if (currentNode.left != null)
                    queue.offer(currentNode.left);

                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            minimumDepth = minimumDepth + 1;
        }

//        If child nodes are not null in above nodes, return whatever is the minimum depth here.
        return minimumDepth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);

        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Minimum Depth : " + MinimumBinaryTreeDepth.findDepth(root));

        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Minimum Depth : " + MinimumBinaryTreeDepth.findDepth(root));
    }

}
