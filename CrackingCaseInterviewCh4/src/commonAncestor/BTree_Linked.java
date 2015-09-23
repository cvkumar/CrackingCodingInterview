package commonAncestor;

import doublylinkedTrees.TreeNode;

public class BTree_Linked<E extends Comparable<E>> {

    private TreeNode<E> root;

    public BTree_Linked () {
        root = null;
    }

    public TreeNode<E> getRoot() {
    	return root;
    }
    
    public void setRoot(E data) {
    	root = new TreeNode<E>(data, null);
    }
    
    public void addLeft(E data) {
    	root.setLeft(new TreeNode<E>(data, root));
    }
    
    public void addRight(E data) {
    	root.setRight(new TreeNode<E>(data, root));
    }
}
