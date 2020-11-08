package stack;

public class StackByLinkedList {

	StackNode root;

	public class StackNode {
		int data;
		StackNode next;

		public StackNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public boolean isEmpty() {
		if (root == null)
			return true;
		return false;
	}

	public void push(int data) {
		StackNode newNode = new StackNode(data);
		if (root == null)
			root = newNode;

		else {
			// incorrect logic
			// root.next = newNode;
			// root = newNode;

			// ROOT >> N1 >> N2 >> N3 => new node will take the place of ROOT i.e. it gets
			// appended before the HEAD node
			newNode.next = root;
			root = newNode;

		}
		System.out.println(data + " has been pushed onto the stack");

	}

	public int pop() {
		int tempNode = Integer.MIN_VALUE;
		if (root == null) {
			System.out.println("stack underflow");
		}

		else {
			tempNode = root.data;
			root = root.next;
		}
		return tempNode;
	}
	
	public int top() {
		int temp = Integer.MIN_VALUE;
		if (root == null) {
			System.out.println("stack underflow");
		}
		
		else {
			temp = root.data;
		}
		return temp;
	}

	public static void main(String[] args) {
		StackByLinkedList stack = new StackByLinkedList();
		System.out.println("is Stack empty " + stack.isEmpty());
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("TOP element is " + stack.top());
		System.out.println("is Stack empty " + stack.isEmpty());
		System.out.println("popped element is " + stack.pop());
		System.out.println("popped element is " + stack.pop());
		System.out.println("TOP element is " + stack.top());
		System.out.println("popped element is " + stack.pop());
		System.out.println("TOP element is " + stack.top());
		System.out.println("popped element is " + stack.pop());
		System.out.println("TOP element is " + stack.top());
	}

}
