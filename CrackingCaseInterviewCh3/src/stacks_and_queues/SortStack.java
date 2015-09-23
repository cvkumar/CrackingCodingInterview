package stacks_and_queues;

import java.util.Stack;

public class SortStack {
	
	static Stack<Integer> sortStack(Stack<Integer> stack) {
		int temp1;
		Stack<Integer> sorted_stack = new Stack<Integer>();
		
		while(!stack.isEmpty()) {
			temp1 = stack.pop();
			while (!sorted_stack.isEmpty() && temp1 < sorted_stack.peek()) {
				stack.push(sorted_stack.pop());
			}
				sorted_stack.push(temp1);
		}
		return sorted_stack;
	}
	
	public static void main(String[] args) {
		Stack<Integer> test = new Stack<Integer>();
		
		test.add(7);
		test.add(2);
		test.add(1);
		test.add(4);
		test.add(5);
		System.out.println(test);
		
		System.out.println(sortStack(test));
	}

}
