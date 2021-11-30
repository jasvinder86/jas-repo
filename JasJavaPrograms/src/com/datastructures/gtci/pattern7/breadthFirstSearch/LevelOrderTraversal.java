package com.datastructures.gtci.pattern7.breadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

}

public class LevelOrderTraversal {

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

//        1. Start a Queue in which nodes will be inserted

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        Q: Why can't we create a new Queue as an Array List? How LinkedList is allowed?
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

            //            3. size of each level will be the count of nodes in the queue.
            int sizeOfCurrentLevel = queue.size();
            List<Integer> listOfElementsAtEachLevel = new ArrayList<>(sizeOfCurrentLevel);

//            4. Traverse the queue n times, where n = no. of nodes in the current level. Also keep adding the left and right nodes of the current element.
            for (int i = 0; i < sizeOfCurrentLevel; i++) {
                TreeNode currentElement = queue.poll();

//                5. add all the elements of the current level in the list.
                listOfElementsAtEachLevel.add(currentElement.data);

                if (currentElement.left != null)
                    queue.offer(currentElement.left);

                if (currentElement.right != null)
                    queue.offer(currentElement.right);
            }

            System.out.print("\nList Of Elements At Each Level : " + listOfElementsAtEachLevel);

//            6. add all the elements of the current list in the final list.
            result.add(listOfElementsAtEachLevel);
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

        LevelOrderTraversal.printElementsDepthWise(root);

        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.print("\nLevel Order Traversal " + result);
    }

}
