package stacks_and_queues;

import stacks_and_queues.Node;

public class Stacks {

	Node top;
	
	boolean empty() {
		return top == null;
	}
	
	Object pop() {
		if (top != null) {
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	void push(Object data) {
		Node item = new Node((int) data);
		item.next = top;
		top = item;
	}
	
	Object peek() {
		if (top == null) return null;
		return top.data;
	}
}
