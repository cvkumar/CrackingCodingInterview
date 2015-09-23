package simpleLinkedList;
import simpleLinkedList.Node;

public class AddOrderedNodes {
	
	static int list_length (Node n) {
		int length = 0;
		
		while(n != null) {
			n = n.next;
			length++;
		}
		return length;
	}
	
	private static int addNode_and_get_leftover(int a, int b, Node prev) {
		if (a + b > 9) {
			prev.append_to_tail(a + b - 10);
			return 1;
		}
		else {
			prev.append_to_tail(a + b);
			return 0;
		}
	}
	
	static Node add_ordered_lists(Node n1, Node n2) {
		
		int l1 = list_length(n1);
		int l2 = list_length(n2);
		Node sum = new Node(0);
		Node prev = sum;
		Node not_nine = sum;
		int carryover = 0;
		
		while(l1!=0 || l2!=0) {
			if (l1 > l2) {
				prev.next = new Node(n1.data);
				l1--;
				
				n1 = n1.next;
				prev = prev.next;
				if(prev.data != 9)
					not_nine = prev;
			}
			else if(l2 > l1) {
				prev.next = new Node(n2.data);
				l2--;
				
				n2 = n2.next;
				prev = prev.next;
				if(prev.data != 9)
					not_nine = prev;
			}
			else { 
				carryover = addNode_and_get_leftover(n1.data, n2.data, prev);
				prev = prev.next;
				l1--;
				l2--;
				n1 = n1.next;
				n2 = n2.next;
				
				if (carryover == 1) {
					not_nine.data++;
					not_nine = prev; //since it carried over, it can't be a nine.
				}
				else if (prev.data != 9) {
					not_nine = prev;
				}
			} // end else statement
		} // end while loop
		if (sum.data == 0)
			return sum.next;
		else
			return sum;
	}

	public static void main(String []args) {
		Node n1 = new Node(2);
		n1.append_to_tail(5);
		
		Node n2 = new Node(3);
		n2.append_to_tail(9);
		n2.append_to_tail(9);
		
		add_ordered_lists(n1, n2).print();
		
	}
}
