package com.datastructures.gtci.pattern8.depthFirstSearch;

/*
Problem Statement
Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.
A path can be defined as a sequence of nodes between any two nodes and doesn't necessarily pass through the root.
*/

public class MaximumPathSum {

    //    Take the maxSum as Integer.MIN_VALUE instead of 0 to accommodate the case of all negative nodes.
    private static int maxSum = Integer.MIN_VALUE;

    public static int findMaximumPathSum(TreeNode root) {
        getMaxSumOfPathRecursively(root);
        return maxSum;
    }

    private static int getMaxSumOfPathRecursively(TreeNode root) {
        if (root == null)
            return 0;

//        Get the maximum sum of left and right paths of each node.
        int sumOfLeftPath = getMaxSumOfPathRecursively(root.left);
        int sumOfRightPath = getMaxSumOfPathRecursively(root.right);

//        If sumOfLeftPath or sumOfRightPath become negative anywhere, return 0 else the sum will reduce further, but we intend to return the max Sum.
        sumOfLeftPath = Math.max(sumOfLeftPath, 0);
        sumOfRightPath = Math.max(sumOfRightPath, 0);

//        Current sum of every node should be compared against the max sum since any node can have the max sum within the tree.
        int sum = sumOfLeftPath + sumOfRightPath + root.data;

        maxSum = Math.max(maxSum, sum);

//        Keep returning the higher sum of the paths of every node to its parent so that further nodes can be examined if they have a higher sum within their children.
        return Math.max(sumOfLeftPath, sumOfRightPath) + root.data;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum path sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum path sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum path sum: " + MaximumPathSum.findMaximumPathSum(root));

    }

}
