package com.datastructures.gtci.pattern8.depthFirstSearch;


public class TreeDiameterIncorrect {

    private static int treeDiameter = 0;

    public static int findDiameter(TreeNode root) {

        if (root == null)
            return -1;

        int rootDiameter = getHeight(root.left) + 1 + getHeight(root.right) + 1 + 1;
        int leftDiameter = getHeight(root.left.left) + 1 + getHeight(root.left.right) + 1 + 1;
        int rightDiameter = getHeight(root.right.left) + 1 + getHeight(root.right.right) + 1 + 1;

        System.out.println("rootDiameter : " + rootDiameter);
        System.out.println("leftDiameter : " + leftDiameter);
        System.out.println("rightDiameter : " + rightDiameter);

        return Math.max((Math.max(leftDiameter, rightDiameter)), rootDiameter);
    }

    public static int findDiameter2(TreeNode currentNode) {

        if (currentNode == null)
            return 0;

        int treeDiameter = 0;
        System.out.println("root : " + currentNode.data);
        int rootDiameter = getHeight(currentNode.left) + getHeight(currentNode.right) + 1;
        System.out.println("rootDiameter : " + rootDiameter);

        return Math.max(treeDiameter, rootDiameter);
    }

    public static int getHeight(TreeNode currentNode) {
        if (currentNode == null)
            return 0;

        int height = Math.max(
                getHeight(currentNode.left),
                getHeight(currentNode.right)
        ) + 1;

        System.out.println("Height of " + currentNode.data + " is :: " + height);
        return height;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);

//        System.out.println("1 -- Diameter of the tree is " + TreeDiameter.findDiameter(root));
//        System.out.println("2 -- Diameter of the tree is " + TreeDiameter.findDiameter2(root));


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

//        System.out.println("1 -- Diameter of the tree is " + TreeDiameter.findDiameter(root1));
        System.out.println("2 -- Diameter of the tree is " + TreeDiameterIncorrect.findDiameter2(root1));

        TreeNode root2 = new TreeNode(1);

        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        root2.left.left = new TreeNode(4);

        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(6);
//        System.out.println("1 -- Diameter of the tree is " + TreeDiameter.findDiameter(root2));
//        System.out.println("2 -- Diameter of the tree is " + TreeDiameter.findDiameter2(root2));
    }

}
