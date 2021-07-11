public class MaximumProductSubarray_1 {

	public static void main(String[] args) {
		MaximumProductSubarray_1 obj = new MaximumProductSubarray_1();
		
		System.out.println(obj.maxProduct(new int[] {2,-3,2,4,2,-1}));
		System.out.println(obj.maxProduct(new int[] {2,-3,2,0,2,-1}));
		System.out.println(obj.maxProduct(new int[] {-2,-3,0,4,2,-1,0}));
		System.out.println(obj.maxProduct(new int[] {3,-1,4}));
	}

	public int maxProduct(int[] nums) {
        int max = nums[0];
        int tempMax = nums[0];
        int tempMin = nums[0];
        
        for(int i=1;i<nums.length;i++){
            int tempMax1 = Math.max(nums[i], Math.max(tempMin*nums[i], tempMax*nums[i]));
            tempMin = Math.min(nums[i], Math.min(tempMin*nums[i], tempMax*nums[i]));
            tempMax = tempMax1;
            
            max = Math.max(max, tempMax1);
        }
        
        return max;
    }
}