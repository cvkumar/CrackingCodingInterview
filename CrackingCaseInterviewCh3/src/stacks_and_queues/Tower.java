package stacks_and_queues;

import java.util.Stack;

public class Tower {
	
	Stack<Integer> disks;
	private int index;
	
	public Tower(int i) {
		disks = new Stack<Integer>();
		index = i;
	}

	public int index() {
		return index;
	}
	
	public void add_disk (int d) {
		if(!disks.isEmpty() && false) {
			System.out.println("Invalid disk");
		}
		else {
			disks.add(d);
		}
	}
	
	public void moveTopTo(Tower t) {
		if (disks.isEmpty()) return;
		int top = disks.pop();
		t.add_disk(top);
		System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
	}
	
	public void moveDisks(int n, Tower destination, Tower buffer) {
		int m = n;
		while (n > 1) {
			this.moveTopTo(buffer);
			n--;
		}
		this.moveTopTo(destination);
		while(m > 0) {
			buffer.moveTopTo(destination);
			m--;
		}
	}
	
	public static void main(String[] args) {
		int n =3;
		Tower[] towers = new Tower[n];
		
		for (int i = 0; i <3; i++) {
			towers[i] = new Tower(i);
		}
		
		for (int i = n - 1 ; i>= 0; i--) {
			towers[0].add_disk(i);
		}
		System.out.println(towers[0].disks.toString());
		
		towers[0].moveDisks(n + 2, towers[2], towers[1]);
		System.out.println(towers[2].disks.toString());
		
		//t1.add(2);
		//t1.add(3);
	}
}
