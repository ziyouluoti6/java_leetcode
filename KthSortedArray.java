// find kth element of 2 sorted array
class KthSortedArray {
	
	public static void main (String[] args)  {
		int[] arr1 = {1, 5, 7, 9}, arr2 = {2, 3, 4, 6, 8, 10, 11};
		System.out.println(findKth(arr1, 0, arr2, 0, 3));
	}
	
	// in every recursive call, idx is current start index of arrx and k is current kth requirement value
	public static int findKth (int[] arr1, int id1, int[] arr2, int id2, int k) {
		
		//always assume arr1 is shorter for convenience
		if (arr1.length - id1 > arr2.length - id2) {
			return findKth(arr2, id2, arr1, id1, k);
		}
		
		//check some corner cases
		// id1 out of arr1 size, so k is in arr2
		if (id1 == arr1.length) {
			return arr2[id2 + k - 1];
		}
		// k is 1, just compare first element of both arrs. Starting index is idx!!!
		if (k == 1) {
			return Math.min(arr1[id1], arr2[id2]);
		}
		// now need compare k/2 element in each arr, but make sure k/2 is existed in arr1 at least
		int k1 = Math.min(k/2, arr1.length - id1), k2 = k - k1;
		
		// kx is number of integers, so in index should minus one
		if (arr1[id1 + k1 - 1] < arr2[id2 + k2 - 1]) {
			// here, kx is to skip numbers, so not index in this case
			return findKth(arr1, id1 + k1, arr2, id2, k - k1);
		} else if (arr1[id1 + k1 - 1] > arr2[id2 + k2 - 1]) {
			return findKth(arr1, id1, arr2, id2 + k2, k - k2);
		} else {
			return arr1[id1 + k1 - 1];
		}
	}
}