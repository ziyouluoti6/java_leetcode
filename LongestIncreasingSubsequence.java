// this is a dynamic problem
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // firstly, check input null or empty
		if (nums == null || nums.length == 0) return 0;
		
		// understand LIS
		// let f(i) as the LIS at index i, then there will have
		// f(j) = max{f(j), f(i) + 1}, f(i) < f(j) (this is increasing condition), 0 <= i < j 
		//      = f(j), not change is condition not satisfied
		// e.g. [1, 3, 5, 2]
		//   f  [1, 2, 3, 2]
		
		// create initial LIS array and result
		int[] f = new int[nums.length];
		Arrays.fill(f, 1);
		int result = 1;
		
		// j is current LIS index, from second
		for (int j = 1; j < nums.length; j++) {
			// i is previous LIS index, from begin
			for (int i = 0; i < j; i++) {
				if (nums[i] < nums[j]) {
					f[j] = Math.max(f[j], f[i] + 1);
				}
			}
			
			// after got each f[i], compare with result to update
			result = Math.max(result, f[j]);
		}
		
		return result;
    }
}