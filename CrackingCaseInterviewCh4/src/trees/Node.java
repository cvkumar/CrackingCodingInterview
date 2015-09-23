package trees;
 
// Declarations for a typical tree-node class
// For a binary search tree, data in nodes must have a comesBefore method
// as well as an equal method.  This node therefore uses the Entry class 
// for data storage.
 
import java.lang.Comparable;
 
public class Node <E extends Comparable<E>> {
 
    protected E data;      // the information to be stored in the node
    protected Node<E> left;   // the pointer to the node's left subtree
    protected Node<E> right;  // the pointer to the node's right subtree
 
    // Constructors
    public Node (E startingData) {
        data = startingData;
        left = null;
        right = null;
    }
 
    public Node (E initData, Node<E> leftNode, Node<E> rightNode) {
        data = initData;
        left = leftNode;
        right = rightNode;
    }
 
    // extractors
    public E getData () {
        return data;
    }
 
    public Node<E> getLeft () {
        return left;
    }
 
    public Node<E> getRight () {
        return right;
    }
 
    // modifiers
    public void setData (E newData) {
        data = newData;
    }
 
    public void setLeft (Node<E> newLeft) {
        left = newLeft;
    }
    public void setRight (Node<E> newRight) {
        right = newRight;
    }
} // TreeNode