package trees;

import java.util.ArrayList;

public class PathSums {

	//Can't enter 0 as val
	public static void printPaths(BTree<Integer> tree, int val) {
		ArrayList<Integer> path = new ArrayList<Integer>();
		traverse(tree.getRoot(), val, path);
	}
	
	public static void traverse(Node<Integer> n, int val, ArrayList<Integer> path) {
		if (n == null) {
			return;
		}
		tryPaths(n, val, path, 0);
		traverse(n.getLeft(), val, new ArrayList<Integer>());
		traverse(n.getRight(), val, new ArrayList<Integer>());
	}
	
	public static void tryPaths(Node<Integer> n, int val, ArrayList<Integer> path, int sum) {
		if (n == null || sum > val) {
			return;
		}
		path.add(n.getData());
		sum += n.getData();
		if (sum == val) {
			System.out.println(path.toString());
		}
		tryPaths(n.getLeft(), val, path, sum);
		tryPaths(n.getRight(), val, path, sum);
	}
	
	public static int findHeight(BTree<Integer> tree) {
		return findHeight(tree.getRoot(), 0);
	}
	public static int findHeight(Node<Integer> n, int height) {
		if (n == null) {
			return height;
		}
		return Math.max(findHeight(n.getLeft(), height + 1), findHeight(n.getRight(), height + 1));
	}
	
	public static void findPaths(BTree<Integer> tree, int val) {
		int[] path = new int[findHeight(tree)];
		findPaths(tree.getRoot(), val, path, 0);
	}
	
	public static void findPaths(Node<Integer> n, int val, int[] path, int level) {
		if (n == null) {
			return;
		}
		
		path[level] = n.getData();
		int sum = 0;
		for (int i = level; i >= 0; i--) {
			sum += path[i];
			if (sum == val) {
				printPath(path, i, level);
			}
		}
		
		findPaths(n.getLeft(), val, path, level + 1);
		findPaths(n.getRight(), val, path, level + 1);
	}
	
	public static void printPath(int[] path, int start, int end) {
		for (int i = start; i <= end ; i++) {
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BTree<Integer> tree = new BTree<Integer>();
		
		tree.setRoot(new Node<Integer>(5));
		tree.addLeft(3);
		tree.addRight(8);
		
		tree.getRoot().getLeft().setLeft(new Node<Integer>(0));
		
		tree.getRoot().getLeft().getLeft().setLeft(new Node<Integer>(8));
		
		findPaths(tree, 8);
	}
}
