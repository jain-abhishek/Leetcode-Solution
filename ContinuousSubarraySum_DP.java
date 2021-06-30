// working but giving TLE as there are 2 loops

public class ContinuousSubarraySum_DP {

	public static void main(String[] args) {
		ContinuousSubarraySum_DP obj = new ContinuousSubarraySum_DP();
		System.out.println(obj.checkSubarraySum(new int[] {23,2,4,6,7}, 17));
		System.out.println(obj.checkSubarraySum(new int[] {2,4,3}, 6));
		System.out.println(obj.checkSubarraySum(new int[] {2,0}, 2));
		System.out.println(obj.checkSubarraySum(new int[] {1,2,12}, 6));
		System.out.println(obj.checkSubarraySum(new int[] {0,0,0}, 6));
		System.out.println(obj.checkSubarraySum(new int[] {5,0,0,0}, 3));
		System.out.println(obj.checkSubarraySum(new int[] {1,2,3}, 5));
		System.out.println(obj.checkSubarraySum(new int[] {0}, 1));
	}

	public boolean checkSubarraySum(int[] nums, int k) {
		int[][] memo = new int[nums.length][nums.length];

		for(int n=0;n<nums.length;n++){
			memo[0][n] = nums[n];    
		}

		for(int i=1;i<nums.length;i++){
			for(int j=i;j<nums.length;j++){
				int num = memo[i-1][j-1] + nums[j];
				if(i>=1 && num % k == 0){
					return true;
				}
				memo[i][j] = num;
			}
		}

		return false;
	}
}
