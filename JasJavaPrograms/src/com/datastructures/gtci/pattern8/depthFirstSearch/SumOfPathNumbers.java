package com.datastructures.gtci.pattern8.depthFirstSearch;

/*
Problem Statement
        Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
        Find the total sum of all the numbers represented by all paths.

    Example
        1
    7        9
          2     9

     Output: 408
     Explanation: The sum of all path numbers: 17 + 192 + 199
*/

public class SumOfPathNumbers {
    static int currentNumber = 0, sum = 0;

    public static int findSumOfPathNumbers(TreeNode root) {
        SumOfPathNumbers.getSumOfAllPathNumbers(root, currentNumber, sum);
        return sum;
    }

    public static void getSumOfAllPathNumbers(TreeNode root, int currentNumber, int sum) {
        if (root == null) {
            return;
        } else {
            currentNumber = currentNumber * 10 + root.data;
            if (root.left == null && root.right == null) {
                SumOfPathNumbers.sum = SumOfPathNumbers.sum + currentNumber;
            }
            getSumOfAllPathNumbers(root.left, currentNumber, sum);
            getSumOfAllPathNumbers(root.right, currentNumber, sum);

        }

    }

    public static void main(String[] args) {
//        Input 1
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(7);
        root.right = new TreeNode(9);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);

        System.out.println("Total sum of path numbers is " + SumOfPathNumbers.findSumOfPathNumbers(root));

//        Input 2
        TreeNode root1 = new TreeNode(1);

        root1.left = new TreeNode(0);
        root1.right = new TreeNode(1);

        root1.left.left = new TreeNode(1);

        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(5);

        System.out.println("Total sum of path numbers is " + SumOfPathNumbers.findSumOfPathNumbers(root1));
    }

}
