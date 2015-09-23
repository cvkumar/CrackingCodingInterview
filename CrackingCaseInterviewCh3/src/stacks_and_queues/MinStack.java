package stacks_and_queues;

import java.util.Stack;

public class MinStack extends Stack<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Stack<Integer> mins;
	
	public MinStack() {
		mins = new Stack<Integer>();
	}
	
	void push(int item) {
		super.push(item);
		if (mins.empty()) {
			mins.push(item);
		}
		else if (item <= mins.peek()) {
			mins.push(item);
		}
	}
	
	public Integer pop() {
		if (super.peek() == mins.peek()) {
			mins.pop();
		}
		return super.pop();
	}
	
	int min() {
		if (mins.isEmpty()) {
			System.out.println("stack is empty");
			return Integer.MAX_VALUE;
		}
		return mins.peek();
	}
	
	public static void main(String[] args) {
		MinStack test = new MinStack();
		test.push(1);
		test.push(2);
		test.push(3);
		test.push(0);
		test.pop();
		
		System.out.println(test.min());
		
	}
}
