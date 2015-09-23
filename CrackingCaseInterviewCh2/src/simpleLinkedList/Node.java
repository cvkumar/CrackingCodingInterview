package simpleLinkedList;

import java.util.HashSet;

public class Node {

	Node next = null;
	int data;

	public Node(int data) {
		this.data = data;
	}

	void append_to_tail(int data) {
		Node new_node = new Node(data);
		Node temp = this;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new_node;
	}

	Node removeNode(int data) {
		if (this.data == data) {
			return this.next;
		}
		Node temp = this;
		while (temp.next != null) {
			if (temp.next.data == data) {
				temp.next = temp.next.next;
				return this;
			}
			temp = temp.next;
		}
		return this;
	}

	void print() {
		System.out.println(this.data + " ");
		Node temp = this;
		while (temp.next != null) {
			temp = temp.next;
			System.out.println(temp.data);
		}
	}
	
	void makeLoop(int data) {
		Node end = this;
		Node loop_start = this;
		while(end.next != null) {
			end = end.next;
		}
		
		while (loop_start != null) {
			if (loop_start.data == data) {
				end.next = loop_start;
				return;
			}
			loop_start = loop_start.next;
		}
	}

	void removeDuplicates() {
		
		if (this.next == null)
			return;
		
		Node first = this;
		Node prev = this;
		Node runner = this.next;
		
		while (first.next != null) {
			runner = first.next;
			while (runner.next != null) {
				if (first.data == runner.data) {
					prev.next = runner.next;
					runner = runner.next;
				} 
				else {
					prev = prev.next;
					runner = runner.next;
				}
			}
			
			if (first.data == runner.data) 
				prev.next = null;
			if (first.next == null) 
				return;
			first = first.next;
			prev = first;
		}
	}
	
	static void book_removeDuplicates(Node head) {
		
		
		HashSet<Integer> set = new HashSet<Integer>();
		Node prev = head;

		while(head != null) {
			if (set.contains(head.data)) {
				System.out.println("true");
				prev.next = head.next;
			}
			else {
				set.add(head.data);
				prev = head;
			}
			head = head.next;
		}
	}
	
	static void removeDupsNoBuffer (Node head) {
		if (head == null)
			return;
		
		Node current = head;
		Node runner;
		while (current != null) {
			runner = current;
			while (runner.next != null) {
				if (current.data == runner.next.data) {
					runner.next = runner.next.next;
				} 
				else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
		
	}

	public static void main(String[] args) {
		Node list = new Node(1);
		list.append_to_tail(2);
		list.append_to_tail(2);
		removeDupsNoBuffer(list);
		list.print();
		
		Node list2 = new Node(2);
		list2.removeDuplicates();
		list2.removeDuplicates();
		//list2.print();
	}
}