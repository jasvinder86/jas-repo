package com.datastructures.gtci.pattern7.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

//        1. Start a Queue in which nodes will be inserted

        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<TreeNode> queue = new ArrayList<TreeNode>(); throws compilation error

//        Q: Why can't we create a new Queue as an Array List? How LinkedList is allowed?
//        A: All Known Implementing Classes:
//              AbstractQueue, ArrayBlockingQueue, ArrayDeque, ConcurrentLinkedDeque, ConcurrentLinkedQueue,
//              DelayQueue, LinkedBlockingDeque, LinkedBlockingQueue, LinkedList, LinkedTransferQueue,
//              PriorityBlockingQueue, PriorityQueue, SynchronousQueue


        if (root == null)
            return result;

//        2. Start by having the root in the queue as initial element
        queue.offer(root);

        while (!queue.isEmpty()) {
            int sizeOfCurrentLevel = queue.size();
            List<Integer> listOfElementsAtEachLevel = new ArrayList<>(sizeOfCurrentLevel);
            for (int i = 0; i < sizeOfCurrentLevel; i++) {
                TreeNode currentElement = queue.poll();
                listOfElementsAtEachLevel.add(currentElement.data);

                if (currentElement.left != null)
                    queue.offer(currentElement.left);

                if (currentElement.right != null)
                    queue.offer(currentElement.right);
            }
            System.out.print("\nList Of Elements At Each Level : " + listOfElementsAtEachLevel);

//            3. Adding at 0th index of LinkedList will keep pushing the existing nodes forward.
            result.add(0, listOfElementsAtEachLevel);
        }
        return result;
    }

    public static void printElementsDepthWise(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                queue.offer(temp.left);

            if (temp.right != null)
                queue.offer(temp.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);

        root.right.right = new TreeNode(5);

        ReverseLevelOrderTraversal.printElementsDepthWise(root);

        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.print("\nReverse Level Order Traversal " + result);
    }

}
