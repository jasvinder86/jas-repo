package com.datastructures.gtci.pattern7.breadthFirstSearch;

/*
Problem Statement: Given a binary tree, connect each node with its level order successor.
        The last node of each level should point to the first node of the next level.
*/

import java.util.LinkedList;
import java.util.Queue;

class TreeNode1 {
    int data;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1 next;

    TreeNode1(int x) {
        data = x;
        left = right = next = null;
    }
}

public class ConnectAllLevelOrderSiblings {

    public static void connect(TreeNode1 root) {

        if (root == null)
            return;

        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode1 previousNode = null, currentNode = null;

        while (!queue.isEmpty()) {
            currentNode = queue.poll();

//            previousNode will be null at the beginning at level 1. Once the 2nd node is reached, previousNode will be initialized to the first node.
//            Then we make it point to the currentNode which is one step ahead of the previousNode.
            if (previousNode != null)
                previousNode.next = currentNode;

            if (currentNode.left != null)
                queue.offer(currentNode.left);
            if (currentNode.right != null)
                queue.offer(currentNode.right);

//            Here the previousNode becomes the next node ie currentNode
            previousNode = currentNode;
        }

    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);

        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);

        root.left.left = new TreeNode1(9);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);

        ConnectAllLevelOrderSiblings.connect(root);

        TreeNode1 current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }


        TreeNode1 root1 = null;
        ConnectAllLevelOrderSiblings.connect(root1);

        current = root1;
        System.out.println("\nTraversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

    }

}
