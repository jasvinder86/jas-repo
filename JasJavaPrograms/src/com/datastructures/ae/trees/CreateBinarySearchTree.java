package com.datastructures.ae.trees;

public class CreateBinarySearchTree {

    public CreateBinarySearchTree() {
        root = null;
    }

    private TreeNode root;

    private class TreeNode {
        private int data;
        private TreeNode right;
        private TreeNode left;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBST(int data) {
        if (root == null) {
            root = new TreeNode(data);
        } else {
            insertNodeAt(root, data);
        }
    }

    private void insertNodeAt(TreeNode currentNode, int inputData) {
        if (inputData < currentNode.data) {
//            insert at the left of this node
            if (currentNode.left != null) {
                insertNodeAt(currentNode.left, inputData);
            } else
                currentNode.left = new TreeNode(inputData);
        } else {
//            insert at the right of this node
            if (currentNode.right != null) {
                insertNodeAt(currentNode.right, inputData);
            } else currentNode.right = new TreeNode(inputData);
        }
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);

    }

    public static void main(String[] args) {
        CreateBinarySearchTree createBinarySearchTree = new CreateBinarySearchTree();
        createBinarySearchTree.createBST(10);
        createBinarySearchTree.createBST(7);
        createBinarySearchTree.createBST(15);
        createBinarySearchTree.createBST(17);
        createBinarySearchTree.createBST(14);
        createBinarySearchTree.createBST(9);
        createBinarySearchTree.createBST(6);

        System.out.println(createBinarySearchTree.root);
        createBinarySearchTree.inOrderTraversal(createBinarySearchTree.root);
    }

}
