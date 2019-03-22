package linkedlist;

public class SinglyLinkedList_DeleteOps {

	Node headNode;

	public static class Node {
		private int data;
		private Node nextNode;

		public Node(int data) {
			this.data = data;
			this.nextNode = null;
		}

	}

	public void displayList(Node node) {
		if (headNode == null)
			System.out.println("Empty list");

		else {
			Node currentNode = node;
			while (currentNode != null) {
				System.out.print(currentNode.data + " > ");
				currentNode = currentNode.nextNode;
			}
			System.out.println(currentNode);
		}
	}

	public void deleteFirstNode() {
		// since we know that we've to delete the first node, I am not passing any
		// arguments to this method. It should delete the head node by default.

		// when head is null
		if (headNode == null)
			System.out.println("head is already null. list is empty ");

		// when there's only 1 node in the LL => head.next = null
		else if (headNode.nextNode == null) {
			System.out.println("list has only one node, its data is : " + headNode.data + ". Deleting that now.");
			headNode = null;
			System.out.println("head node is now : " + headNode);
		}

		// when list has 2 or more nodes
		else {
			System.out.println("list has 2 or more nodes");
			headNode = headNode.nextNode;
			System.out.println("removed the original head node. Head node now is " + headNode.data);
		}
	}

	public void deleteNodeWithGivenData1(int data) {
		Node pointerNode = null;
		// 1 2 3 4 5 .. delete node with data 3
		pointerNode = headNode;
		// pointerNode = 1

		while (pointerNode.nextNode != null && pointerNode.nextNode.data != data) {
			pointerNode = pointerNode.nextNode;
		}
		// currently at node with data 2
		pointerNode.nextNode = pointerNode.nextNode.nextNode;
	}

	public void deleteNodeWithGivenData(int data) {
		Node pointerNode = null;
		Node nextToPointerNode = null;

		// null
		if (headNode == null) {
			System.out.println("list is already empty");
			return;
		}

		// 1 null
		// if first element is the one to remove
		if (headNode.data == data) {
			headNode = headNode.nextNode;
			return;
		}

		// 1 2 3 4 5 null.. delete node with data 4
		pointerNode = headNode;
		while (pointerNode != null) {
			nextToPointerNode = pointerNode.nextNode;
			if (nextToPointerNode != null && nextToPointerNode.data == data) {
				pointerNode.nextNode = nextToPointerNode.nextNode;
			} else if (nextToPointerNode == null) {
				System.out.println("reached the end of list, data didnt match");
				return;
			} 
				pointerNode = pointerNode.nextNode;
		}

	}

	public static void main(String[] args) {
		SinglyLinkedList_DeleteOps operations = new SinglyLinkedList_DeleteOps();
		operations.headNode = new Node(10);
		Node firstNode = new Node(20);
		Node secondNode = new Node(30);
		Node thirdNode = new Node(40);
		Node fourthNode = new Node(50);
		//
		operations.headNode.nextNode = firstNode;
		firstNode.nextNode = secondNode;
		secondNode.nextNode = thirdNode;
		thirdNode.nextNode = fourthNode;

		operations.displayList(operations.headNode);

		// operations.deleteFirstNode();
		// operations.displayList(operations.headNode);

		operations.deleteNodeWithGivenData(50);
		operations.displayList(operations.headNode);

	}
}
