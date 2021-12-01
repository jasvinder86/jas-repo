package com.datastructures.gtci.pattern7.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

//        1. Make a queue.
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

//        2. Insert the root in the queue as the first element.
        queue.offer(root);
        int level = 1;

//        3. Traverse till the size of the queue and keep inserting the nodes on each level in a list.
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            List<Integer> listOfNodesAtCurrentLevel = new LinkedList<Integer>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

//                If level is odd, simply add the nodes ie they'll be added to the end of the list by default
                if (level % 2 == 1)
                    listOfNodesAtCurrentLevel.add(currentNode.data);

//                If level is even, add the nodes at the first index so that current nodes will keep shifting to the right.
                else
                    listOfNodesAtCurrentLevel.add(0, currentNode.data);

                if (currentNode.left != null)
                    queue.offer(currentNode.left);

                if (currentNode.right != null)
                    queue.offer(currentNode.right);

            }
            result.add(listOfNodesAtCurrentLevel);

            //            Keep incrementing the level by 1 just before the next iteration of the while loop so that next level gets added accordingly
            level++;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);

        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);

        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.print("\nZigzag Traversal " + result);
    }
}