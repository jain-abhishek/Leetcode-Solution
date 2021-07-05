public class MinimumOperationstoReduceXtoZero {
	
	public static void main(String[] args) {
		MinimumOperationstoReduceXtoZero obj = new MinimumOperationstoReduceXtoZero();
		System.out.println(obj.minOperations(new int[] {1,1,4,2,3}, 5));
		System.out.println(obj.minOperations(new int[] {5,6,7,8,9}, 4));
		System.out.println(obj.minOperations(new int[] {5,6,7,8,9}, 100));
		System.out.println(obj.minOperations(new int[] {1,1}, 3));
		System.out.println(obj.minOperations(new int[] {1,1,4,2,3}, 3));
		System.out.println(obj.minOperations(new int[] {3,2,20,1,1,3}, 10));
	}

	public int minOperations(int[] nums, int target) {
        int sum = 0;
        for(int k=0;k<nums.length;k++){
            sum += nums[k];   
        }
        
        target = sum - target;
        if(target == 0){
            return nums.length;
        }
        
        if(target < 0){
            return -1;
        }
        
        int i=0;
        int j=0;
        sum = 0;
        int maxDis = Integer.MIN_VALUE;
            
        for(i=0;i<nums.length;i++){
            sum = sum + nums[i];
            while(sum >= target){
                if(sum == target){ // important
                    maxDis = Math.max(i-j+1, maxDis);
                }
                sum = sum - nums[j];
                j++;
            }
        }
        
        return maxDis == Integer.MIN_VALUE ? -1 : nums.length - maxDis;
    }
}
