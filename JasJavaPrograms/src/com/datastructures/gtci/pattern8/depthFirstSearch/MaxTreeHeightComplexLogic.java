package com.datastructures.gtci.pattern8.depthFirstSearch;

public class MaxTreeHeightComplexLogic {

    public static int getHeight(TreeNode root) {

        int currentHeight = -1;
        return getMaximumHeight(root, currentHeight);

    }

    private static int getMaximumHeight(TreeNode root, int currentHeight) {
        if (root != null) {
            System.out.println("Root is " + root.data);
            currentHeight += 1;
            System.out.println("currentHeight @ " + root.data + " is " + currentHeight);
            return Math.max(
                    getMaximumHeight(root.left, currentHeight),
                    getMaximumHeight(root.right, currentHeight));
        }
        return currentHeight;
    }

    public static void main(String[] args) {
        TreeNode root1 = null;
        System.out.println("Height of the tree is " + MaxTreeHeightComplexLogic.getHeight(root1));

        TreeNode root = new TreeNode(1);
        System.out.println("Height of the tree is " + MaxTreeHeightComplexLogic.getHeight(root));

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Height of the tree is " + MaxTreeHeightComplexLogic.getHeight(root));

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println("Height of the tree is " + MaxTreeHeightComplexLogic.getHeight(root));

        root.left.right.left = new TreeNode(6);
        System.out.println("Height of the tree is " + MaxTreeHeightComplexLogic.getHeight(root));

    }

}
