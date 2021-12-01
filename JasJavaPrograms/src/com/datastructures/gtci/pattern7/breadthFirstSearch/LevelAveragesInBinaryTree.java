package com.datastructures.gtci.pattern7.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAveragesInBinaryTree {

// Problem statement: Given a binary tree, populate an array to represent the averages of all of its levels.

    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null)
            return result;

//        1. Start with taking a queue having the root
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

//        2. Traverse till queue isn't empty
        while (!queue.isEmpty()) {

//            3. Get count of nodes at the current level
            int denominator = queue.size();

//            4. initialize sumOfCurrentLevel = 0
            double sumOfCurrentLevel = 0;

//            5. Find average of each level.
            for (int i = 0; i < denominator; i++) {
                TreeNode currentNode = queue.poll();
                sumOfCurrentLevel = sumOfCurrentLevel + currentNode.data;

//                6. Add children od the current node to the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }

//            7. Get average of each level
            double averageOfCurrentLevel = sumOfCurrentLevel / denominator;

//            8. Add averages to the result list
            result.add(averageOfCurrentLevel);

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode nullRoot = null;
        List<Double> result1 = LevelAveragesInBinaryTree.findLevelAverages(nullRoot);
        System.out.println("Level averages are " + result1);

        TreeNode root = new TreeNode(12);

        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAveragesInBinaryTree.findLevelAverages(root);
        System.out.println("Level Averages are " + result);

    }
}
