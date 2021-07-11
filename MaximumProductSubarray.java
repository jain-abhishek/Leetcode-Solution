public class MaximumProductSubarray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] {2,-3,2,4,2,-1}));
		System.out.println(maxProduct(new int[] {2,-3,2,0,2,-1}));
		System.out.println(maxProduct(new int[] {-2,-3,0,4,2,-1,0}));
		System.out.println(maxProduct(new int[] {3,-1,4}));
	}

	public static int maxProduct(int[] nums) {
		int[] leftProd = new int[nums.length];
		leftProd[0] = nums[0];
		int maxProd = leftProd[0];

		for(int i=1;i<nums.length;i++){
			if(leftProd[i-1] == 0) { // this is important
				leftProd[i] = nums[i];
			}
			else {
				leftProd[i] = leftProd[i-1] * nums[i];
			}
			
			maxProd = Math.max(maxProd, leftProd[i]);
		}      

		maxProd = Math.max(maxProd, nums[nums.length-1]); //this is important
		
		for(int i=nums.length-2;i>=0;i--){
			if(nums[i+1] != 0) {
				nums[i] = nums[i] * nums[i+1];
			}
			
			maxProd = Math.max(maxProd, nums[i]);
		}      

		return maxProd;
	}
}