package basicSortingAlgs;

import java.util.Arrays;

public class QuickSort {

	public static void quicksort(int[] list) {
		
	}
	
	public static int partition(int[] list) {
		if (list.length == 0) {
			System.out.println("list empty");
			return Integer.MIN_VALUE;
		}
		return partition(list, 1, list.length-1, 0);
	}
	
	public static int partition(int[] list, int lo, int hi, int p) {
		if (lo > hi) {
			int temp = list[lo-1];
			list[lo-1] = list[p];
			list[p] = temp;
			return lo-1;
		}
		int pivot = list[p];
		if (list[lo] > pivot && list[hi] < pivot) {
			int temp = list[lo];
			list[lo] = list[hi];
			list[hi] = temp;
			return partition(list, lo+1, hi-1, p);
		}
		if(list[lo] > pivot) {
			return partition(list, lo, hi -1, p);
		}
		if (list[hi] < pivot) {
			return partition(list, lo+1, hi, p);
		}
		return partition(list, lo+1, hi-1, p);
	}
	
	public static int[] swap(int [] list, int a, int b) {
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
		return list;
	}
	
	public static void quickSort(int arr[], int left, int right) {
		if(right <= left) {
			return;
		}
		int index = partition(arr, left+1, right, left);
		quickSort(arr, index+1, right);
		quickSort(arr, left, index-1);
	}
	
	
	public static int findKthLargest(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
	 
		return getKth(nums.length - k +1, nums, 0, nums.length - 1);
	}
	
	
	public static int getKth(int k, int[] nums, int start, int end) {
		 
		int pivot = nums[end];
	 
		int left = start;
		int right = end;
	 
		while (true) {
	 
			while (nums[left] < pivot && left < right) {
				left++;
			}
	 
			while (nums[right] >= pivot && right > left) {
				right--;
			}
	 
			if (left == right) {
				break;
			}
	 
			swap(nums, left, right);
		}
	 
		swap(nums, left, end);
	 
		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}
	 
	
	public static void main(String[] args) {
		/* Partition Testing
		int[] test = {7,2,3,8,5,9,6,9,7};
		test = partition(test, 1, test.length-1);
		
		System.out.println(Arrays.toString(test));
		
		int[] test2 = {8,7,5,4,3,2,1};
		test2 = partition(test2, 1, test2.length-1);
		
		System.out.println(Arrays.toString(test2));
		
		int[] test3 = {1,2,3,4,5,6,7,8};
		test3 = partition(test3, 1, test3.length-1);
		System.out.println(Arrays.toString(test3));
		
		int[] test4 = {2,1,3};
		test4=partition(test4,1,test4.length-1);
		System.out.println(Arrays.toString(test4));
		
		int[] one = {1};
		one=partition(one);
		System.out.println(Arrays.toString(one));
		*/
		
		int[] test = {2,1,3,4,0,9,-1,10,-1};
		//quickSort(test, 0, test.length-1);
		System.out.println(Arrays.toString(test));
		
		
		System.out.println(findKthLargest(test, 1));
	}
}
