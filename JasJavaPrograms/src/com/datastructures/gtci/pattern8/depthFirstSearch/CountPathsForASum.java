package com.datastructures.gtci.pattern8.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Statement
 * Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values of each path equals ‘S’.
 * Please note that the paths can start or end at any node but all paths must follow direction from parent to child (top to bottom).
 *
 * I have made some modifications to the solution - I also return the paths where we attain the desired sum. Hence, if a question
 * of such type comes, that can be solved using this approach. If only sum of such paths is required, we won't need the variable allPaths.
 * We can simply return the count of such paths (ie count of tempPath variable used below).
 *
 * DOUBTS:
 * 1. Compare my approach vs others
 * 2. Calculate the time complexity
 *
 */

public class CountPathsForASum {

    public static int countPaths(TreeNode root, int S) {

        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsRecursively(root, S, currentPath, allPaths);

        return allPaths.size();
    }

    public static void findPathsRecursively(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (root == null)
            return;

        currentPath.add(root.data);

//        if leaf node has been reached
        if (root.left == null && root.right == null) {

/*
    Find in this path if sum of the nodes add up to the desired sum value.
    Start from the leaf node and keep adding that to a temporary list and its value to a currentSum variable.
    The moment currentSum matches the desire sum, all the temporary list to the variable final list.
    Keep traversing the list upto the last node since it may be possible that a single path contains two sub-paths that add up to the desired sum.
*/
            int currentSum = 0;
            List<Integer> tempPath = new ArrayList<>();
            for (int i = currentPath.size() - 1; i >= 0; i--) {
                tempPath.add(currentPath.get(i));
                currentSum = currentSum + currentPath.get(i);

                if (currentSum == sum) {
                    allPaths.add(new ArrayList<>(tempPath));
                }
            }

        } else {
            findPathsRecursively(root.left, sum, currentPath, allPaths);
            findPathsRecursively(root.right, sum, currentPath, allPaths);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);

        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);

        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountPathsForASum.countPaths(root, 11));
    }
}
