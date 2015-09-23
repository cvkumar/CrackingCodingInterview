package simpleLinkedList;

import java.util.Stack;

public class Palindrome {
	
	static boolean isPalindrome(Node head) {
		if (head == null) return false;
		
		Node fast = head;
		Node slow = head;
		Stack<Integer> stack = new Stack<Integer>();
		
		//slow will reach middle of list
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		//If fast != null (fast.next == null) then odd length list so want slow one past middle
		if (fast != null) slow = slow.next;
		
		while (slow != null) {
			if (stack.pop() != slow.data) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}

	public static void main (String[] args) {
		Node test1 = new Node(1);
		test1.append_to_tail(2);
		test1.append_to_tail(3);
		test1.append_to_tail(2);
		test1.append_to_tail(1);
		
		System.out.println(isPalindrome(test1));
		
		Node test2 = new Node(1);
		test2.append_to_tail(3);
		test2.append_to_tail(3);
		test2.append_to_tail(1);
		
		System.out.println(isPalindrome(test2));
		
		Node test3 = new Node(1);
		test3.append_to_tail(2);
		test3.append_to_tail(3);
		
		System.out.println(isPalindrome(test3));
		
		Node one = new Node(1);
		System.out.println(isPalindrome(one));
		
	}
}
