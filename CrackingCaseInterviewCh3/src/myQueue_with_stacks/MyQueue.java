package myQueue_with_stacks;

import java.util.Stack;

public class MyQueue {

	Stack<Integer> stack1;
	Stack<Integer> stack2;
	
	public MyQueue () {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	int size () {
		return stack1.size() + stack2.size();
	}
	
	void add(int item) {
		stack1.push(item);
	}
	
	void shiftStacks() {
		int item;
		while(!stack1.isEmpty()) {
			item = stack1.pop();
			stack2.push(item);
		}
	}
	
	int peek() {
		if (stack2.isEmpty()) {
			if (stack1.isEmpty()) return Integer.MAX_VALUE;
			this.shiftStacks();
		}
		return stack2.peek();
	}
	
	int remove() {
		if (stack2.isEmpty()) {
			if (stack1.isEmpty()) return Integer.MAX_VALUE;
			this.shiftStacks();
		}
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		MyQueue test = new MyQueue();
		
		test.add(3);
		test.add(2);
		test.add(1);
		
		System.out.println(test.remove());
		test.add(3);
		System.out.println(test.peek());
		
		
	}
}