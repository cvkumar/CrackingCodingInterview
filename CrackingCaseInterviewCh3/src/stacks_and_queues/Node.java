package stacks_and_queues;

public class Node {

	Node next = null;
	int data; 
	
	public Node (int data) {
		this.data = data;
	}
	
	void append_to_tail (int data) {
		
		Node new_node = new Node(data);
		Node temp = this;
		
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = new_node;
	}
	
	Node removeNode (int data) {
		
		if (this.data == data) {
			return this.next;
		}
		
		Node temp = this;
		
		while(temp.next != null) {
			if (temp.next.data == data) {
				temp.next = temp.next.next;
				return this;
			}
			temp = temp.next;
		}
		return this;
	}
	
	void makeLoop(int data) {
		
		Node end = this;
		while (end.next != null) {
			end = end.next;
		}
		
		Node start_loop = this;
		while (start_loop != null) {
			if (start_loop.data == data) {
				end.next = start_loop;
				return;
			}
			start_loop = start_loop.next;
		}
		
		System.out.println("Data was not found");
		return;
	}
	
	void print() {
		System.out.println(this.data + " ");
		Node temp = this;
		
		while(temp.next != null) {
			temp = temp.next;
			System.out.println(temp.data);
		}
	}
	
	void removeDuplicates() {
		
		if(this.next == null) {
			return;
		}
		
		Node first = this;
		Node prev = this;
		Node runner = this.next;
		
		while(first.next != null) {
			while(runner.next != null) 	{
				if (first.data == runner.data) {
					prev.next = runner.next;
					runner = runner.next;
				}
				else {
					System.out.println(first.data + " " + runner.data);
					prev = prev.next;
					runner = runner.next;
				}
			}
			first = first.next;
			prev = first;
			runner = first.next;
		}
	}
	
	public static void main (String []args) {
		Node list = new Node(1);
		list.append_to_tail(2);
		list.append_to_tail(2);
		
		list.removeDuplicates();
		list.print();
	}
}
