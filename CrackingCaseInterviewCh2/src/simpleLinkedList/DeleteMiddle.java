package simpleLinkedList;

public class DeleteMiddle {

	static void delete_middle (Node middle) {
		if(middle == null || middle.next == null) return;
		middle.data = middle.next.data;
		middle.next = middle.next.next;
	}
}
