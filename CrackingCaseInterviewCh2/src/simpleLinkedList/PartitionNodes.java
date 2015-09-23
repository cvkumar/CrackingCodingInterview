package simpleLinkedList;

public class PartitionNodes {

	static void partition(Node head, int x) {
		Node runner = head;
		Node prev = head;
		
		while (runner != null) {
			if (runner.data > x) {
				move_to_right(prev, runner, x);
			}
			
		}
	}
	
	static boolean move_to_right (Node prev, Node n, int x) {
		prev.next = n.next;
		Node runner = n;
		while (runner.next != null) {
			if (runner.data == x) {
				n = runner.next;
				runner.next = n;
				return true;
			}
		}
		return false;
	}
	
	static void move_to_left (Node head, Node prev, Node n) {
		prev.next = n.next;
		n.next = head;
	}
	
	static Node book_partition (Node node, int x) {
		Node head = node;
		Node tail = node;
		
		while(node != null) {
			Node next = node.next;
			if (node.data < x) {
				//add to front
				node.next = head;
				head = node;
			}
			else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		
		return head;
	}
	
	public static void main(String []args) {
		
	Node test1 = new Node(3);
	test1.append_to_tail(2);
	test1.append_to_tail(4);
	test1.append_to_tail(1);
	test1.print();
	
	test1 = book_partition(test1, 2);
	
	System.out.print("\n\n");
	
	test1.print();
	
	}
}
