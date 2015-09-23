package trees;

public class MinHeightTree {


	public static Node<Integer> makeMinTree(int start, int end, int numbers[]) {
		if (end < start) {
			return null;
		}
		
		int mid = (start + end) /2;
		Node<Integer> n = new Node<Integer>(numbers[mid]);
		n.setLeft(makeMinTree(start, mid - 1, numbers));
		n.setRight(makeMinTree(mid + 1, end, numbers));
		return n;
	}
	
	public static Node<Integer> makeMinTree(int numbers[]) {
	return makeMinTree(0, numbers.length - 1, numbers);	
	}
	
	
	public static void main(String[] args) {
		int[] numbers = {1,2,3};
		Node <Integer> test = makeMinTree(numbers);
		BSTree<Integer> tree = new BSTree<Integer>();
		tree.setRoot(test);
		
		tree.print();
	}
	
}
