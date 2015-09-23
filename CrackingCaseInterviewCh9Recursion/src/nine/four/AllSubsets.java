package nine.four;

import java.util.ArrayList;

//Return all Subsets of a set
/*runtime 2^n since this is how many subsets there are
 * 
 * Recurse until at end, then create subsets starting w/ empty set
 * Then starting from end of index, create new subsets by adding that indexes value to all existing subsets
 * and then add the new subsets until we've gone through every val in set
 * 
 * 
 */

public class AllSubsets {
	
	public static ArrayList<ArrayList<Integer>> getSets(ArrayList<Integer> set) {
		return getSets(set, 0);
	}
	
	public static ArrayList<ArrayList<Integer>> getSets(ArrayList<Integer>set, int index) {
		if (index > set.size() - 1) {
			ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
			subsets.add(new ArrayList<Integer>());
			return subsets;
		}
		else {
			ArrayList<ArrayList<Integer>> subsets = getSets(set, index+1);
			int val = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> s : subsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(s);
				newsubset.add(val);
				moresubsets.add(newsubset);
			}
			subsets.addAll(moresubsets);
			return subsets;
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[5];
		
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		
		ArrayList<ArrayList<Integer>> subsets = getSets(set);
		
		int b = 5;
		b++;
	}
}
