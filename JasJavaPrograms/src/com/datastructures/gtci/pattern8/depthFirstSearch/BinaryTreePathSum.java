package com.datastructures.gtci.pattern8.depthFirstSearch;

/*
Problem Statement
Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals ‘S’.
*/

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
    }
}

public class BinaryTreePathSum {

    public static boolean hasPath(TreeNode root, int sum) {

//        If root is null, it means leaf node has been reached but the sum has not matched.
        if (root == null)
            return false;

//        If leaf node has been reached and it matches the desire number, return true.
        if (root.data == sum && root.left == null && root.right == null)
            return true;


//        else make recursive calls taking left and right sub-trees, and if any of these returns true solution is found
        return
//          recursive call in left child
                hasPath(root.left, sum - root.data)

                        ||

//          recursive call in right child
                        hasPath(root.right, sum - root.data);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);

        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        System.out.println("Tree has path : " + BinaryTreePathSum.hasPath(root, 23));

        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path : " + BinaryTreePathSum.hasPath(root, 23));
        System.out.println("Tree has path : " + BinaryTreePathSum.hasPath(root, 16));
    }
}
