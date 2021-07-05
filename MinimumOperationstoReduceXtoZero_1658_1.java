import java.util.HashMap;
import java.util.Map;

public class MinimumOperationstoReduceXtoZero_1 {
	public static void main(String[] args) {
		MinimumOperationstoReduceXtoZero_1 obj = new MinimumOperationstoReduceXtoZero_1();
		System.out.println(obj.minOperations(new int[] {1,1,4,2,3}, 5));
		System.out.println(obj.minOperations(new int[] {5,6,7,8,9}, 4));
		System.out.println(obj.minOperations(new int[] {5,6,7,8,9}, 100));
		System.out.println(obj.minOperations(new int[] {1,1}, 3));
		System.out.println(obj.minOperations(new int[] {1,1,4,2,3}, 3));
		System.out.println(obj.minOperations(new int[] {3,2,20,1,1,3}, 10));
	}

	public int minOperations(int[] nums, int target) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];   
        }
        
        target = sum - target;
        if(target == 0)
            return nums.length;
        
        Map<Integer, Integer> map= new HashMap<>();
        int maxSize = Integer.MIN_VALUE;
        
        map.put(0, -1);
        sum = 0;
        
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            if(map.containsKey(sum - target)){
                maxSize = Math.max(maxSize, i - map.get(sum - target));
            }  
            map.put(sum, i);
        }
        
        return maxSize == Integer.MIN_VALUE ? -1 : nums.length - maxSize;
    }
}
