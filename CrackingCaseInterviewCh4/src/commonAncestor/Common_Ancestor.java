package commonAncestor;

import trees.BTree;
import trees.Node;
import doublylinkedTrees.TreeNode;

//Solution with no links
public class Common_Ancestor {

	public static Node<Integer> findAncestor (BTree<Integer> tree, Node<Integer> n1, Node<Integer> n2) {
		return findAncestor(tree.getRoot(), n1, n2);
	}
	public static Node<Integer> findAncestor(Node<Integer> root, Node<Integer> n1, Node<Integer> n2) {
		if (root == null) return null;
		if(root == n1 || root == n2) return root;
		
		boolean isonLeft1 = isUnder(root.getLeft(), n1);
		boolean isonLeft2 = isUnder(root.getLeft(), n2);
		
		if (isonLeft1 && isonLeft2) {
			return findAncestor (root.getLeft(), n1, n2);
		}
		
		if (!isonLeft1 && !isonLeft2) {
			return findAncestor(root.getRight(), n1, n2);
		}
		return root;
	}
	public static boolean isUnder(Node<Integer> root, Node<Integer> n) {
		if (root == null) return false;
		if (root == n) return true;
		return isUnder(root.getLeft(), n) || isUnder(root.getRight(), n);
	}
	
	//More optimized w/ links to parents
	//MY SOLUTION SINCE I CAN'T UNDERSTAND THEIRS
	public static boolean inSubtree(TreeNode<Integer> root, TreeNode<Integer> n) {
		if (root == null) {
			return false;
		}
		else if (root == n) {
			return true;
		}
		else {
			return inSubtree(root.getLeft(), n) || inSubtree(root.getRight(), n);
		}
	}
	
	public static TreeNode<Integer> commonAncestor(BTree_Linked<Integer> tree, 
			TreeNode<Integer> n1, TreeNode<Integer> n2) {
		if (inSubtree(n1, n2)) {
			return n1;
		}
		return commonAncestor(n1, n2);
	}
		
	public static TreeNode<Integer> commonAncestor(TreeNode<Integer> n1, TreeNode<Integer> n2) {
		TreeNode<Integer> parent = n1.getParent();
		if (parent == null) {
			return null;
		}
		
		if (n1 == parent.getLeft()) {
			if (inSubtree(parent.getRight(), n2)) return parent;
		}
		
		if (n2 == parent.getRight()) {
			if (inSubtree(parent.getLeft(), n1)) return parent;
		}
		
		return commonAncestor(n1.getParent(), n2);
	}
	
	public static void main(String[] args) {
		BTree<Integer> tree = new BTree<Integer>();
		tree.setRoot(new Node<Integer>(5));
		tree.addLeft(8);
		tree.addRight(3);
		tree.getRoot().getLeft().setLeft(new Node<Integer>(10));
		tree.getRoot().getLeft().setRight(new Node<Integer>(12));
		
		//System.out.println(findAncestor(tree, tree.getRoot().getLeft(), tree.getRoot().getLeft().getRight()).getData());
		
		BTree_Linked<Integer> tree2 = new BTree_Linked<Integer>();
		tree2.setRoot(5);
		tree2.addLeft(8);
		tree2.addRight(10);
		tree2.getRoot().getLeft().addLeft(0);
		tree2.getRoot().getLeft().addRight(100);
		
		System.out.println(commonAncestor(tree2, tree2.getRoot().getLeft().getLeft(), tree2.getRoot().getLeft().getRight()).getData());
	}
}
