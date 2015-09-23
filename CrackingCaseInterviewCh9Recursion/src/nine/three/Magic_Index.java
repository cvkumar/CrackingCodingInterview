package nine.three;

//Magic Index: defined to be when a[i] = i
public class Magic_Index {

	
	public static int magicFinderSlow(int[] arr, int i) {
		if(i >= arr.length || i < arr[i]) {
			return Integer.MAX_VALUE;
		}
		if (i == arr[i]) {
			return i;
		}
		return magicFinderSlow(arr, i+1);
	}
	
	public static int myMagicFinder(int[] arr) {
		return myMagicFinder(arr, 0, arr.length-1);
	}
	
	public static int myMagicFinder(int[] arr, int left, int right) {
		if (left > right || left < 0 || right >= arr.length) {
			return Integer.MIN_VALUE;
		}
		int mid = (left+right)/2;
		if (mid == arr[mid]) {
			return mid;
		}
		if (arr[mid] < mid) {
			return myMagicFinder(arr, mid+1, right);
		}
		else {
			return myMagicFinder(arr, left, mid-1);
		}
	}
	
	//NonDistinct MagicFinder
	
	public static int magicFinder2(int[] arr, int left, int right) {
		if (left > right || left < 0 || right >= arr.length) {
			return Integer.MIN_VALUE;
		}
		int mid = (left+right)/2;
		if (mid == arr[mid]) {
			return mid;
		}
		Integer a = checkIndices(arr, arr[mid]);
		if (a != null) {
			return a;
		}
		if (arr[mid] < mid) {
			return myMagicFinder(arr, mid+1, right);
		}
		else {
			return myMagicFinder(arr, left, mid-1);
		}
	}
	
	public static Integer checkIndices(int[] arr, int i) {
		if (i < 0 || i > arr.length) {
			return null;
		}
		if (arr[i] == i) {
			return i;
		}
		else {
			return checkIndices(arr, arr[i]);
		}
	}
	
	public static void main (String[] args) {
		int[] arr = {0,3,5};
		//System.out.println(myMagicFinder(arr));
		
		int[] arr2 = {-10,5,2,2,2,3,4,7,9,12,13};
		System.out.println(magicFinder2(arr2, 0, arr2.length-1));
	}
}
