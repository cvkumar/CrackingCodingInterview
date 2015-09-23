package simpleLinkedList;

import java.util.HashSet;

public class Start_Of_Loop {
	
	static Node findLoop (Node n) {
		HashSet<Node> set = new HashSet<Node>();
		while(n != null) {
			if (set.add(n)) {
				System.out.println(n.data);
				n = n.next;
			}
			else {
				return n;
			}
		}
		System.out.println("No loop");
		return null;
	}
	
	static Node book_findLoop(Node n) {
		if (n == null) return null;
		
		Node slow = n;
		Node fast = n;
		
		while (fast != null|| fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			System.out.println("No loop :(");
			return null;
		}
		
		//At collision were k(steps from head till loop) steps from the loop start
		slow = n;
		
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		Node n = new Node(1);
		n.append_to_tail(2);
		n.append_to_tail(3);
		n.append_to_tail(4);
		n.append_to_tail(5);
		n.makeLoop(3);
		
		System.out.println(book_findLoop(n).data);
	}
}
