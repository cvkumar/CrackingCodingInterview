package stacks_and_queues;

import stacks_and_queues.Node;

public class Queue {

	Node first, last;
	
	void enqueue (Object data) {
		if(first == null) {
			last = new Node((int)data);
			first = last;
		}
		else {
			Node item = new Node((int)data);
			last.next = item;
			last = item;
		}
	}
	
	Object dequeue () {
		if (first != null) {
			int item = first.data;
			first = first.next;
			if (first == null) last = null;
			return item;
		}
		return null;
	}
}
