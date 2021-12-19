package com.datastructures.gtci.pattern8.depthFirstSearch;

//DOUBT: Debugger isn't working as I expected at line number 53. How come?
/*
Problem Statement
        Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.

Example             1
               7        9
                      2   9

                      Sequence = [1,9,9]
                      Output = true because there is a path 1 -> 9 -> 9 in the tree
*/

public class PathWithGivenSequence {

    public static boolean findPath(TreeNode root, int[] sequence) {
        int currentSequenceIndex = 0;
        return findRecursivePath(root, sequence, currentSequenceIndex);
    }

    private static boolean findRecursivePath(TreeNode root, int[] sequence, int currentSequenceIndex) {
        if (root == null || currentSequenceIndex >= sequence.length || root.data != sequence[currentSequenceIndex])
            return false;

        else if (root.data == sequence[currentSequenceIndex]) {
            if (root.left == null
                    && root.right == null
                    && currentSequenceIndex + 1 == sequence.length) {
                return true;
            } else
                return
                        (findRecursivePath(root.left, sequence, currentSequenceIndex + 1))
                                ||
                                (findRecursivePath(root.right, sequence, currentSequenceIndex + 1));
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(0);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(1);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence : " + PathWithGivenSequence.findPath(root, new int[]{1, 1, 6}));
        System.out.println("Tree has path sequence : " + PathWithGivenSequence.findPath(root, new int[]{1, 1, 5}));
        System.out.println("Tree has path sequence : " + PathWithGivenSequence.findPath(root, new int[]{1, 0, 5}));
        System.out.println("Tree has path sequence : " + PathWithGivenSequence.findPath(root, new int[]{1, 1, 1}));
    }

}
