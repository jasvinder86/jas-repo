package com.datastructures.gtci.pattern7.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/*
Problem Statement:
Given a binary tree and a node, find the level order successor of the given node in the tree.
The level order successor is the node that appears right after the given node in the level order traversal.
*/
public class LevelOrderSuccessor {

    public static TreeNode findSuccessor(TreeNode root, int key) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

//                if key matches the current node, return the next node in the queue
//                if key is the last element in the queue, retun null will be done by the return statement ot the end of this method.
            if (key == currentNode.data) {
                break;
            }
        }
        return (queue.poll());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);

        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.data + " ");

        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            System.out.println(result.data + " ");

    }
}
