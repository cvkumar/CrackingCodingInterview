package doublylinkedTrees;

import trees.Node;

public class BSTree_Linked<E extends Comparable<E>> {
	 
	private TreeNode<E> root;

	public BSTree_Linked() {
	        root = null;
	}
	
	public TreeNode<E> getRoot() {
		return root;
	}
	    
	    public void insert (E newEntry) {
	        if (root == null)
	            root = new TreeNode<E>(newEntry, null);
	        else {
	        	TreeNode<E> ptr = root;  // pointer to node in search for leaf
	            while (ptr != null) {// search for leaf
	                if (newEntry.compareTo(ptr.getData()) < 0) {
	                    // insert on left of given node
	                    if (ptr.getLeft() == null) {
	                        // when at end of tree, insert
	                        ptr.setLeft(new TreeNode<E>(newEntry, ptr));
	                        return; 
	                    } 
	                    else {
	                        // move left in tree and continue search
	                        ptr = ptr.getLeft();
	                    }
	                } 
	                else {
	                    // insert on right of given node
	                    if (ptr.getRight() == null) {
	                        // when at end of tree, insert
	                        ptr.setRight(new TreeNode<E>(newEntry, ptr));
	                        return;
	                    } 
	                    else {
	                        // move right in tree and continue search
	                        ptr = ptr.getRight();
	                    }
	                }
	            } // end while loop
	        }
	    } // end method
	    
	    public TreeNode<E> lookup (E desiredItem) {
	        return lookupKernel (root, desiredItem);
	    }

	    public TreeNode<E> lookupKernel (TreeNode<E> base, E desiredItem) {
	        if (base == null)
	            return null;
	        else if (base.getData().compareTo(desiredItem) == 0)
	            return base;
	        else if (base.getData().compareTo(desiredItem) < 0)
	            return lookupKernel (base.getRight(), desiredItem);
	        else return lookupKernel (base.getLeft(), desiredItem);
	    }
	    
	  //In order Traversal
	    public void print () {
	        System.out.println ("Directory Listing");
	        printKernel (root);
	        System.out.println ();
	        System.out.println ("End of Listing");
	    }

	    private void printKernel (TreeNode<E> base) {
	        // to print elements in a tree (using an in-order traversal),
	        //     print the left subtree
	        //     print the elements in a node
	        //     print the right subtree
	        if (base != null) {
	            printKernel (base.getLeft());
	            System.out.print(base.getData());
	            printKernel (base.getRight());
	        }
	    }
	    
	    public static void main(String[] args) {
	    	BSTree_Linked<Integer> tree = new BSTree_Linked<Integer>();
	    	tree.insert(6);
	    	
	    	//leftside
	    	tree.insert(2);
	    	tree.insert(1);
	    	tree.insert(4);
	    	tree.insert(3);
	    	tree.insert(5);
	    	
	    	//rightside
	    	tree.insert(9);
	    	tree.insert(11);
	    	tree.insert(10);
	    	
	    	tree.print();
	    	
	    }
}

	        
