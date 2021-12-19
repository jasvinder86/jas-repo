package com.datastructures.gtci.pattern8.depthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPossiblePaths {

    public static List<List<Integer>> findAllPaths(TreeNode root) {
        List<List<Integer>> allPossiblePaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsRecursively(root, currentPath, allPossiblePaths);
        return allPossiblePaths;
    }

    public static void findPathsRecursively(TreeNode root, List<Integer> currentPath, List<List<Integer>> allPossiblePaths) {

        if (root == null)
            return;

        currentPath.add(root.data);

        if (root.left == null && root.right == null) {
            allPossiblePaths.add(new ArrayList<>(currentPath));

        } else {
            findPathsRecursively(root.left, currentPath, allPossiblePaths);
            findPathsRecursively(root.right, currentPath, allPossiblePaths);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(0);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        System.out.println("All possible paths are " + PrintAllPossiblePaths.findAllPaths(root));

    }

}
