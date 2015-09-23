package simpleLinkedList;

public class List_Reverser {

	static Node reverseList (Node head) {
		if(head == null) return null;
		
		Node prev = head;
		Node runner = head.next;
		
		while (runner != null) {
			prev.next = runner.next;
			runner.next = head;
			head = runner;
			runner = prev.next;
		}
		return head;
	}
	
	public static void main (String[] args) {
		Node test1 = new Node(1);
		test1.append_to_tail(2);
		test1.append_to_tail(3);
		test1.append_to_tail(4);
		
		reverseList(test1).print();
		
		Node one = new Node(1);
		reverseList(one).print();
	}
}
