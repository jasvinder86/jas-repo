package com.datastructures.gtci.pattern8.depthFirstSearch;

public class TreeDiameter {

    private static int treeDiameter = 0;

    public static int findDiameter(TreeNode root) {

        getHeight(root);
        return treeDiameter;
    }

    private static int getHeight(TreeNode currentNode) {

        if (currentNode == null)
            return 0;

//        1. Find the height of every node recursively. Return 0 when a node is null.
//        2. Calculate diameter of every node and set it in a variable.
//        3. Diameter of that node will be the height(leftNode) + height(rightNode) + 1.

        int leftHeight = getHeight(currentNode.left);
        int rightHeight = getHeight(currentNode.right);

        int diameter = leftHeight + rightHeight + 1;
        treeDiameter = Math.max(treeDiameter, diameter);

        return (Math.max(leftHeight, rightHeight) + 1);

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);
        System.out.println("Diameter of the tree is " + TreeDiameter.findDiameter(root));

        TreeNode root1 = new TreeNode(1);

        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(6);

        root1.right.left.left = new TreeNode(7);
        root1.right.left.right = new TreeNode(8);

        root1.right.right.left = new TreeNode(9);

        root1.right.left.right.left = new TreeNode(10);
        root1.right.right.left.left = new TreeNode(11);

        System.out.println("Diameter of the tree is " + TreeDiameter.findDiameter(root1));

    }
}
