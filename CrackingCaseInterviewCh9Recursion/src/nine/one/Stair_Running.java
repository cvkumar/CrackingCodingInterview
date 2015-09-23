package nine.one;

public class Stair_Running {

	//O(3^n)?
	public static int findWays(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		return findWays(n-3) + findWays(n-2) + findWays(n-1);
	}
	
	public static int findWays2(int n) {
		int [] ways = new int[n + 1];
		return findWays2(n, ways);
	}
	
	public static int findWays2(int n, int[] ways) {
		if (n < 0) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		if(ways[n] > 0) return ways[n];
		ways[n] = findWays2(n-3, ways) + findWays2(n-2, ways) + findWays2(n-1, ways);
		return ways[n];
	}
	
	
	public static void main(String[] args) {
		System.out.println(findWays2(5));
	}
}
