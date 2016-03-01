/*
Given an integer array, search a target number in it, return -1 if it doesn’t exist
or return the index of this number otherwise.
*/

public class BinarySearchTemplate {
	public int binarySearch(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;
		
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target){
				start = mid;
			} else {
				end = mid;
			}
		}

		if (A[start] == target) {
			return start;
		}

		if (A[end] == target) {
			return end;
		}

		return -1;

	}
}