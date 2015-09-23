package nine.five;

import java.util.ArrayList;

public class PermutationFinder {

	
	/*str is a unique string
	 * 
	 */
	public static void findPermutations(String str, String prefix) {
		int size = str.length();
		if (size == 0) {
			System.out.println(prefix);
		}
		else {
			for (int i = 0; i < size; i++) {
				findPermutations(str.substring(0, i) + str.substring(i+1, size), prefix + str.charAt(i));
			}
		}
	}
	
	
	public static void main(String[] args) {
		String test = "cat";
		
		findPermutations(test, "");
	}
}
