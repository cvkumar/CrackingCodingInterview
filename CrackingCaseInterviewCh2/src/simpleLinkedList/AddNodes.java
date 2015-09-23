package simpleLinkedList;

public class AddNodes {

	static Node addNodes (Node n1, Node n2) {
		//if (n1 == null && n2 == null)
		int leftover = 0;
		Node head = new Node(0);
		
		while(n1 != null || n2 != null) {
			if(n2 == null) {
				leftover = addNode_and_get_leftover(n1.data, 0, leftover, head);
				n1 = n1.next;
			}
			else if (n1 == null) {
				leftover = addNode_and_get_leftover(n2.data, 0, leftover, head);
				n2 = n2.next;
			}
			else {
				leftover = addNode_and_get_leftover(n2.data, n1.data, leftover, head);
				
				n1 = n1.next;
				n2 = n2.next;
			}
		}
		return head.next;
	}
		
		static int addNode_and_get_leftover(int a, int b, int c, Node head) {
			if (a + b + c > 9) {
				head.append_to_tail(a + b + c - 10);
				return 1;
			}
			else {
				head.append_to_tail(a + b +c);
				return 0;
			}
		}
		
		//ISSUE WE DONT KNOW WHERE DIGITS END FOR EACH LIST SO WE DONT WHAT # IT IS
		static Node add_ordered_nodes(Node n1, Node n2) {
			
			Node head = new Node(0);
			Node prev = head;
			int carryover = 0;
			
			while(n1 != null || n2 != null) {
			
				if (n1 == null) {
					prev.next = new Node (n2.data);
					
					prev = prev.next;
					n2 = n2.next;
				}
				if (n2 == null) {
					prev.next = new Node(n1.data);
					
					prev = prev.next;
					n1 = n1.next;
				}
				else {
					carryover = addNode_and_get_leftover(n1.data, n2.data, 0, prev);
					prev.data += carryover;
					
					prev = prev.next;
					n1 = n1.next;
					n2 = n2.next;
				}	
			}
			
			if (head.data == 0)
				return head.next;
			else
				return head;
		}
		
		public static void main(String[] args) {
			Node test1a = new Node(6);
			test1a.append_to_tail(1);
			test1a.append_to_tail(7);
			
			Node test1b = new Node(2);
			test1b.append_to_tail(9);
			test1b.append_to_tail(5);
			
			add_ordered_nodes(test1a, test1b).print();
		}
	
}
