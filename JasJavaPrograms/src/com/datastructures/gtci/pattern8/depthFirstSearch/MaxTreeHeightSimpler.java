package com.datastructures.gtci.pattern8.depthFirstSearch;

public class MaxTreeHeightSimpler {

//    Assumption: Single node's height is 0 and for null, it is -1.

    public static int getHeight(TreeNode root) {
        if (root == null)
            return -1;

        return (
                Math.max(
                        getHeight(root.left),
                        getHeight(root.right)
                ) + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);

        System.out.println("Height of the tree is " + MaxTreeHeightSimpler.getHeight(root));
    }

}
