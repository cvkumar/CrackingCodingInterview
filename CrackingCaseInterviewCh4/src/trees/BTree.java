package trees;

public class BTree <E extends Comparable<E>>  {

	 private Node<E> root;
	 
	    public BTree () {
	        root = null;
	    }
	 
	    public Node<E> getRoot() {
	    	return root;
	    }
	    
	    public void setRoot(Node<E> n) {
	    	root = n;
	    }
	    
	    public void addLeft(E data) {
	    	root.setLeft(new Node<E>(data));
	    }
	    
	    public void addRight(E data) {
	    	root.setRight(new Node<E>(data));
	    }
	     
	  //Pre order Traversal
	    public void prePrint () {
	        System.out.println ("Directory Listing");
	        preprintKernel (root);
	        System.out.println ();
	        System.out.println ("End of Listing");
	    }
	     
	    public void preprintKernel(Node<E> base) {
	        if (base != null) {
	            System.out.print(base.getData());
	            //System.out.print(base.getLeft().getData());
	            preprintKernel (base.getLeft());
	            preprintKernel (base.getRight());
	        }
	    }
	     
	    public void postPrint() {
	         System.out.println ("Directory Listing");
	         postprintKernel (root);
	         System.out.println ();
	         System.out.println ("End of Listing");
	    }
	     
	    public void postprintKernel(Node<E> base) {
	        if (base != null) {
	            //System.out.print(base.getLeft().getData());
	            postprintKernel (base.getLeft());
	            postprintKernel (base.getRight());
	            System.out.print(base.getData());
	        }
	    }
	}
