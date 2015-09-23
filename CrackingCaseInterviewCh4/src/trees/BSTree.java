package trees;
 
public class BSTree <E extends Comparable<E>> {
 
    private Node<E> root;
 
    BSTree () {
        root = null;
    }
 
    public Node<E> getRoot() {
    	return root;
    }
    
    public void setRoot(Node<E> n) {
    	root = n;
    }
    
    public void insert (E newEntry) {
        if (root == null)
            root = new Node<E>(newEntry);
        else {
            Node<E> ptr = root;  // pointer to node in search for leaf
            while (ptr != null) {// search for leaf
                if (newEntry.compareTo(ptr.getData()) < 0) {
                    // insert on left of given node
                    if (ptr.getLeft() == null) {
                        // when at end of tree, insert
                        ptr.setLeft(new Node<E>(newEntry));
                        return; 
                    } else
                        // move left in tree and continue search
                        ptr = ptr.getLeft();
                } else {
                    // insert on right of given node
                    if (ptr.getRight() == null) {
                        // when at end of tree, insert
                        ptr.setRight(new Node<E>(newEntry));
                        return;
                    } else
                        // move right in tree and continue search
                        ptr = ptr.getRight();
                }
            }
             
        }
    }
 
    //In order Traversal
    public void print () {
        System.out.println ("Directory Listing");
        printKernel (root);
        System.out.println ();
        System.out.println ("End of Listing");
    }
 
    private void printKernel (Node<E> base) {
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
 
    public E lookup (E desiredItem) {
        return lookupKernel (root, desiredItem);
    }
 
    public E lookupKernel (Node<E> base, E desiredItem) {
        if (base == null)
            return null;
        else if (base.getData().compareTo(desiredItem) == 0)
            return base.getData();
        else if (base.getData().compareTo(desiredItem) < 0)
            return lookupKernel (base.getRight(), desiredItem);
        else return lookupKernel (base.getLeft(), desiredItem);
    }
     
    public int getHeight(Node<E> root) {
        if (root == null) {
            return 0;
        }
        else if (root.getLeft() != null) {
            return 1 + getHeight(root.getLeft());
        }
        else {
            return 1 + getHeight(root.getRight());
        }
    }
     
    // PROBLEM 1
    public boolean isBalanced(Node<E> root) {
        if (root == null) {
            return true;
        }
        else if (getHeight(root.getRight()) > getHeight(root.getLeft()) + 1 || 
                getHeight(root.getRight()) < getHeight(root.getLeft()) - 1) {
            return false;
        }
        else {
            return isBalanced(root.getRight()) && isBalanced(root.getLeft());
        }
    }
    
    public int checkHeight(Node<E> root) {
    	if (root == null) {
    		return 0;
    	}
    	
    	int leftHeight = checkHeight(root.getLeft());
    	if(leftHeight == -1) {
    		return -1;
    	}
    	int rightHeight = checkHeight(root.getRight());
    	if (rightHeight == -1) {
    		return -1;
    	}
    	
    	int diff = rightHeight-leftHeight;
    	
    	if(Math.abs(diff) > 1) {
    		return -1;
    	}
    	else {
    		return Math.max(leftHeight, rightHeight) + 1;
    	}    	
    }
    
 // PROBLEM 2
	
	public void deleteNode(E e) {
		
	}
	
	public void removeLeaf(E e) {
		Node<E> n = root;
		if (root == null) return;
		
		//Find the Node
		while(n != null) {
			if (n.data.compareTo(e) > 0) {
				n = n.getLeft();
			}
			else if (n.data.compareTo(e) < 0) {
				n = n.getRight();
			}
			else {
				break;
			}
		}
		if (n == null) return;
		
		if (n.getLeft() == null && n.getRight() == null) {
			
		}
	}

    public static void main(String[] args) {
        BSTree<Integer> test = new BSTree<Integer>();
        test.insert(5);
        //left
        test.insert(1);
        test.insert(0);
        test.insert(-1);
         
        //right
        test.insert(7);
        test.insert(8);
         
         
        System.out.println(test.checkHeight(test.root));
    }
}