package stacks_and_queues;

import java.util.EmptyStackException;

public class Three_Stack_Array {
int stackSize = 100;
int[] buffer = new int[stackSize * 3];
int[] stackPointer = {-1, -1, -1};

int top_of_stack(int stackNum) {
	return stackNum * stackSize + stackPointer[stackNum];
}

void push(int stackNum, int data) {
	if (stackPointer[stackNum] + 1 >= stackSize) {
		System.out.println("Given stack is full");
		throw new IllegalStateException();
		}
	stackPointer[stackNum]++;
	buffer[top_of_stack(stackNum)] = data;
	}

int pop(int stackNum) {
	
	if (isEmpty(stackNum)) {
		throw new EmptyStackException();
	}
	int value = buffer[top_of_stack(stackNum)];
	buffer[top_of_stack(stackNum)] = 0;
	stackPointer[stackNum]--;
	return value;
	}

boolean isEmpty(int stackNum) {
		return stackPointer[stackNum] == -1;
	}

int peek (int stackNum) {
	if (isEmpty(stackNum)) {
		throw new EmptyStackException();
		}
	return buffer[top_of_stack(stackNum)];
	}

public static void main(String[] args) {
	Three_Stack_Array stack = new Three_Stack_Array();
	stack.push(0, 1);
	stack.push(1, 1);
	stack.push(2, 1);
	
	System.out.println(stack.peek(0));
	System.out.println(stack.peek(1));
	System.out.println(stack.peek(2));
	
	}
}
