package doublylinkedTrees;

public class FindNext {

	public static TreeNode<Integer> inorderSucc(TreeNode<Integer> n) {
		if (n.getRight() == null) {
			TreeNode<Integer> parent = n.getParent();
			if (parent == null) return null;
			if (parent.getLeft() != null && parent.getLeft() == n) {
				return parent;
			}
			// We are a rightchild with no rightchild of our own
			// We need to find a parent with me as the leftchild
			TreeNode<Integer> x = parent;
			parent = parent.getParent();
			while(parent != null) {
				if (parent.getLeft() == x) {
					return parent;
				}
				x = parent;
				parent = parent.getParent();
			}
			return null;
		}
		n = n.getRight();
		while(n.getLeft() != null) {
			n = n.getLeft();
		}
		return n;
	}
	
	public static TreeNode<Integer> findLeftMost(TreeNode<Integer> n) {
		while(n.getLeft() != null) {
			n = n.getLeft();
		}
		return n;
	}
	
	
	public static void main (String[] args) {
		BSTree_Linked<Integer> tree = new BSTree_Linked<Integer>();
		
		tree.insert(6);
		
		//leftside
    	tree.insert(2);
    	tree.insert(1);
    	tree.insert(4);
    	tree.insert(3);
    	tree.insert(5);
    	
    	//rightside
    	tree.insert(7);
    	tree.insert(9);
    	tree.insert(8);
    	
    	//tree.print();
    	
    	System.out.println(inorderSucc(tree.lookup(5)).getData());
	}
}
