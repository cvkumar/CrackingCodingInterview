package stacks_and_queues;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {

	int stackSize;
	int currentSize;
	int currentStack;
	ArrayList <Stack<Integer>> stacks;
	
	public SetOfStacks(int size) {
		currentStack = 0;
		currentSize = 0;
		stackSize = size;
		stacks = new ArrayList<Stack<Integer>>();
	}
	
	void push(int data) {
		if (currentSize == stackSize) {
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(data);
			stacks.add(stack);
			currentSize = 1;
			currentStack++;
			return;
		}
		else {
			stacks.get(currentStack).push(data);
			currentSize++;
		}
	}
	
	int pop() {
		if (stacks.isEmpty()) return Integer.MAX_VALUE;
		
		if (currentSize == 0) {
			currentStack--;
			currentSize = stackSize - 1;
			return stacks.get(currentStack).pop();
		}
		else {
			currentSize--;
			return stacks.get(currentStack).pop();
		}
	}
	
	int peek() {
		if (stacks.isEmpty()) return Integer.MAX_VALUE;
		
		return stacks.get(currentStack).peek();
	}
	
	int popAt(int index) {
		if(index > currentStack) return Integer.MAX_VALUE;
		
		int item = stacks.get(index).pop();
		currentStack = index;
		stack
	}
}
