package com.datastructures.lc.nc.trees;

public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftHt = maxDepth(root.left);
        int rightHt = maxDepth(root.right);
        return Math.max(leftHt, rightHt) + 1;

    }

    public static void main(String[] args) {
        TreeNode root = null;
        System.out.println(MaximumDepthOfBinaryTree.maxDepth(root));

        root = new TreeNode(1);
        System.out.println(MaximumDepthOfBinaryTree.maxDepth(root));

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(MaximumDepthOfBinaryTree.maxDepth(root));

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(MaximumDepthOfBinaryTree.maxDepth(root));

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(MaximumDepthOfBinaryTree.maxDepth(root));
    }
}
