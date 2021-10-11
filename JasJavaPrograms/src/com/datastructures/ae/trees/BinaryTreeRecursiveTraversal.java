package com.datastructures.ae.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeRecursiveTraversal {

    /*
    The root node should be present in the parent class since that will contain the entire tree. This is similar to
    the headNode of a LinkedList which should be present in the parent class so that it can refer to the
    next nodes.
    */

    Node root;

    class Node {

        /*
        Root declaration is of no use here since there won't be any node.root i.e. a node can't contain a root.
        Rather since a root contains a node, the root node has been declared in the outer class.
        Node root;
         */
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }

    }

    public Node createBinaryTree() {
        Node first = new Node(9);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        return root;

    }

    public void preOrderRecursiveTraversal(Node root) {
        if (root == null)
            return;

        else {
            System.out.print(root.data + " ");
            preOrderRecursiveTraversal(root.left);
            preOrderRecursiveTraversal(root.right);
        }
    }

    //First print the left node, then root node and then right node
    public void inOrderRecursiveTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderRecursiveTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderRecursiveTraversal(root.right);
    }

    public void levelOrderTraversal(Node root) {
        System.out.println("\n :: levelOrderTraversal ::");
//        1. Check if root is null, simply return
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
//        Inserted the root node to begin the operation
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.data + " ");
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }

    }

    public int findMaximumValue(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int result = node.data;
        int left = findMaximumValue(node.left);
        int right = findMaximumValue(node.right);

        result = result > left ? result : left;
        result = result > right ? result : right;

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeRecursiveTraversal binaryTree = new BinaryTreeRecursiveTraversal();
        binaryTree.createBinaryTree();
//        Node root = binaryTree.createBinaryTree();
        System.out.print("preOrderRecursiveTraversal >> ");
        binaryTree.preOrderRecursiveTraversal(binaryTree.root);
        System.out.println();
        System.out.print("inOrderRecursiveTraversal >> ");
        binaryTree.inOrderRecursiveTraversal(binaryTree.root);
        binaryTree.levelOrderTraversal(binaryTree.root);
        System.out.println("\nMax number is : " + binaryTree.findMaximumValue(binaryTree.root));
    }


}
