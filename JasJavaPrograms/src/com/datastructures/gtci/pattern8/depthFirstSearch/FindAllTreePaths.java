package com.datastructures.gtci.pattern8.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement
        Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
*/

public class FindAllTreePaths {

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        findAllPaths(root, sum, currentPath, allPaths);

        return allPaths;
    }


    private static void findAllPaths(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {

        if (root == null) {
            return;
        }

        TreeNode currentNode = root;
        currentPath.add(currentNode.data);

        if (currentNode.data == sum && currentNode.left == null && currentNode.right == null) {
            allPaths.add(new ArrayList<>(currentPath));

        } else {
            findAllPaths(currentNode.left, sum - currentNode.data, currentPath, allPaths);

            findAllPaths(currentNode.right, sum - currentNode.data, currentPath, allPaths);
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

        int sum = 23;

        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }

}
