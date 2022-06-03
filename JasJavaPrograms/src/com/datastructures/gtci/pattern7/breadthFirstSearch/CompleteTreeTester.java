package com.datastructures.gtci.pattern7.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteTreeTester {

    static class TreeNodeClass {
        int data;
        TreeNodeClass leftNode;
        TreeNodeClass rightNode;

        public TreeNodeClass(int data) {
            this.data = data;
        }
    }

    public static boolean isTreeComplete(TreeNodeClass root) {

//        Error case
        if (root == null)
            return true;

        Queue<TreeNodeClass> queue = new LinkedList<TreeNodeClass>();

//        1. Start with inserting the root node
        queue.offer(root);
        boolean endOfTree = false;

        while (!queue.isEmpty()) {
            TreeNodeClass outgoingNode = queue.poll();

//            2. if the upcoming node is null, there shouldn't be any more nodes after it, so turn the flag of end to true
            if (outgoingNode == null) {
                endOfTree = true;
            } else {
//                3. if the outgoing flag from the previous call is not null and the flag for end is set to true,
//                it means a null node was encountered earlier and the current node is not null => this is not a complete tree.

                if (endOfTree)
                    return false;
                queue.offer(outgoingNode.leftNode);
                queue.offer(outgoingNode.rightNode);
            }
        }
//        4. If queue gets empty at the end, this tree is definitely a complete tree.
        return true;
    }

    public static void main(String[] args) {
        TreeNodeClass root = new TreeNodeClass(1);

        root.leftNode = new TreeNodeClass(2);
        root.rightNode = new TreeNodeClass(3);

        root.leftNode.leftNode = new TreeNodeClass(4);
        root.leftNode.rightNode = new TreeNodeClass(5);

        root.rightNode.leftNode = new TreeNodeClass(6);
        System.out.println(CompleteTreeTester.isTreeComplete(root));

        root.rightNode.rightNode = new TreeNodeClass(7);
        System.out.println(CompleteTreeTester.isTreeComplete(root));

        root.rightNode.rightNode.leftNode = new TreeNodeClass(8);
        System.out.println(CompleteTreeTester.isTreeComplete(root));
    }


}
