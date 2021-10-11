package com.datastructures.ae.trees;

import java.util.Stack;

public class BinaryTreeIterativeTraversal {

    public TreeNode rootNode;

    class TreeNode {
        int data;
        TreeNode rightNode;
        TreeNode leftNode;

        public TreeNode(int data) {
            this.data = data;
        }

        public void preOrder() {
            if (rootNode == null)
                return;

            Stack<TreeNode> nodeStack = new Stack<>();
            nodeStack.push(rootNode);

        }

    }

}
