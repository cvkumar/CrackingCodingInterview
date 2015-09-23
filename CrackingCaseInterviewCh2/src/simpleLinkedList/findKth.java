package simpleLinkedList;

public class findKth {
	
	static int find_kth_from_end (Node head, int k) {
		if (head == null || k < 0) return -1;
		
		Node runner = head;
		Node current = head;
		while (runner.next != null) {
			if (k > 0) {
				runner = runner.next;
				k--;
			}
			else {
				current = current.next;
				runner = runner.next;
			}
		}
		if (k == 0) {
			return current.data;
		}
		else return -1;
	}

public static void main(String []args) {
	Node list1 = new Node(1);
	list1.append_to_tail(2);
	list1.append_to_tail(3);
	
	Node list2 = new Node(1);
	list2.append_to_tail(2);
	list2.append_to_tail(3);
	list2.append_to_tail(4);
	
	Node one = new Node(1);
	
	System.out.println(find_kth_from_end(list1, 3));
	System.out.println(find_kth_from_end(list2, 0));
	System.out.println(find_kth_from_end(one, 1));
	
	}
	
}
