package com.datastructures.gtci.pattern7.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

// Problem Statement: Given a binary tree, connect each node with its level order successor. The last node of each level should point to a null node.
//DOUBT : Not sure about the null case

public class ConnectLevelOrderSiblings {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode(int x) {
            data = x;
            left = right = next = null;
        }


        public void printLevelOrder() {
            TreeNode nextLevelRoot = this;
            while (nextLevelRoot != null) {
                TreeNode current = nextLevelRoot;
                nextLevelRoot = null;

                while (current != null) {
                    System.out.print(current.data + " ");
                    if (nextLevelRoot == null) {
                        if (current.left != null)
                            nextLevelRoot = current.left;

                        else if (current.right != null)
                            nextLevelRoot = current.right;
                    }
                    current = current.next;
                }
                System.out.println();
            }

        }

    }

    public static void connect(TreeNode root) {

        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (queue.isEmpty() || i == levelSize - 1)
                    currentNode.next = null;

                else
                    currentNode.next = queue.peek();

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }

        }


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);

        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();

        TreeNode root1 = null;
        ConnectLevelOrderSiblings.connect(root1);
        System.out.println("Level order traversal using 'next' pointer: ");
        root1.printLevelOrder();
    }

}
