package com.datastructures.gtci.pattern7.breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

class CTreeNode {
    CTreeNode right;
    CTreeNode left;
    CTreeNode next;
    int data;

    CTreeNode(int data) {
        this.data = data;
    }

    public void printLevelOrder() {
        CTreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            CTreeNode current = nextLevelRoot;
            nextLevelRoot = null;

            while (current != null) {
                System.out.print(current.data + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;

                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }

    }

}

public class ConnectLevelOrderSiblingsRevision {

    public static void connect(CTreeNode root) {

        if (root == null)
            return;

        Queue<CTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        CTreeNode currentNode = null;

        while (!queue.isEmpty()) {
            int currentQueueSize = queue.size();

//            Traverse the for loop till current size of the queue
            for (int i = 0; i < currentQueueSize; i++) {
                currentNode = queue.poll();
                currentNode.next = queue.peek();

                if (currentNode.left != null)
                    queue.offer(currentNode.left);

                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            currentNode.next = null;
        }
    }


    public static void main(String[] args) {
        CTreeNode root = new CTreeNode(12);

        root.left = new CTreeNode(7);
        root.right = new CTreeNode(1);

        root.left.left = new CTreeNode(9);
        root.right.left = new CTreeNode(10);
        root.right.right = new CTreeNode(5);

        connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();

    }

}
