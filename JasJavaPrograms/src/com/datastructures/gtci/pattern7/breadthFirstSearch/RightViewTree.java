package com.datastructures.gtci.pattern7.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Problem Statement : Given a binary tree, return an array containing nodes in its right view.
The right view of a binary tree is the set of nodes visible when the tree is seen from the right side.
*/

public class RightViewTree {

    public static List<TreeNode> traverse(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            TreeNode temp = null;
            for (int i = 0; i < levelSize; i++) {

//                Temp will keep getting overwritten and will exit the for loop having the last node of the current level.
                temp = queue.poll();

//                Alternate approach is to check if (i == levelSize - 1) ie if its the last node, result.add(temp)

                if (temp.left != null)
                    queue.offer(temp.left);

                if (temp.right != null)
                    queue.offer(temp.right);

            }
            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args) {

//        Input #1
        System.out.println("Output 1");
        TreeNode root = new TreeNode(12);

        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        root.left.left.left = new TreeNode(3);

        List<TreeNode> result = RightViewTree.traverse(root);
        for (TreeNode node : result) {
            System.out.println(node.data + " ");
        }

//        Input #2
        System.out.println("Output 2");
        TreeNode root1 = new TreeNode(1);

        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        List<TreeNode> result1 = RightViewTree.traverse(root1);
        for (TreeNode node : result1) {
            System.out.println(node.data + " ");
        }

    }
}
