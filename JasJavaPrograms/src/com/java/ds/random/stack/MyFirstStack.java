package com.java.ds.random.stack;

public class MyFirstStack {

	int MAX = 10;
	int top;
	int[] array = new int[MAX];

	public MyFirstStack() {
		top = -1;
	}

	public boolean push(int data) {
		if (top >= MAX - 1) {
			System.out.println("com.java.ds.stack overflow");
			return false;
		} else {
			array[++top] = data;
			System.out.println(data + " pushed onto com.java.ds.stack");
			return true;
		}
	}

	public int pop() {
		if (top == -1) {
			System.out.println("com.java.ds.stack underflow");
			return 0;
		} else {
			int popped = array[top--];
			return popped;
		}
	}

	public boolean isEmpty() {
		if (top == -1) {
			System.out.println("com.java.ds.stack is empty");
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		MyFirstStack stack = new MyFirstStack();
		stack.push(10);
//		com.java.ds.stack.push(20);
//		com.java.ds.stack.push(30);
		System.out.println("element popped is " + stack.pop());
		System.out.println("element popped is " + stack.pop());
	}

}
