package trees;

public class Subtree_Checker {

	//Check if t2 is a subtree of t1
	static boolean isSubtree(BTree<Integer> t1, BTree<Integer> t2) {
		return isSubtree(t1.getRoot(), t2.getRoot());
	}
	
	static boolean isSubtree(Node<Integer> n1, Node<Integer> n2) {
		if (n1 == null) {
			return false;
		}
		else if (n1.getData() == n2.getData()) {
			return isSameTree(n1, n2);
		}
		else {
			return isSubtree(n1.getLeft(), n2) || isSubtree(n1.getRight(), n2);
			}
	}
	
	static boolean isSameTree(Node<Integer> n1, Node<Integer> n2) {
		if (n2 == null) {
			return true;
		}
		else if (n1 == null ||n1.getData() != n2.getData()) {
			return false;
		}
		return isSameTree(n1.getLeft(), n2.getLeft()) && isSameTree(n1.getRight(), n2.getRight());
	}
	
	public static void main(String[] args) {
		BTree<Integer> t1 = new BTree<Integer>();
		BTree<Integer> t2 = new BTree<Integer>();
		
		t1.setRoot(new Node<Integer>(5));
		t1.addLeft(8);
		t1.addRight(4);
		t1.getRoot().getRight().setRight(new Node<Integer>(0));
		
		t2.setRoot(new Node<Integer>(4));
		t2.addRight(0);
		
		System.out.println(isSubtree(t1, t2));
	}
	
}
