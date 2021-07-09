public class MinimumSizeSubarraySum {
	public static void main(String[] args) {
		MinimumSizeSubarraySum obj = new MinimumSizeSubarraySum();
		System.out.println(obj.minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
		System.out.println(obj.minSubArrayLen(4, new int[] {2,-3,1,6,-4,5}));
		System.out.println(obj.minSubArrayLen(11, new int[] {1,2,3,4,5}));
		System.out.println(obj.minSubArrayLen(3, new int[] {1,1}));
	}

	public int minSubArrayLen(int s, int[] nums) {
		int min = Integer.MAX_VALUE;
		int j = 0;
		int sum = 0;
		for(int i=0;i<nums.length;i++) {
			sum = sum + nums[i];
			while(sum>=s) {
				min = Math.min(i-j+1, min);
				sum = sum - nums[j];
				j++;
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}
	
}
