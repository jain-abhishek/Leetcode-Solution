// Math: c = a % k, c = b % k, so we have a % k = b % k
// keep taking running sum and mod, if the same value is found again that means such subarray exists. eg: 23,2,4,6,7 for k=17 => 6,8,12,1,8 so 8 was already found means such subarray exists. 

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

	public static void main(String[] args) {
		ContinuousSubarraySum obj = new ContinuousSubarraySum();
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
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;

		for(int i=0;i<nums.length;i++){
			sum = (sum + nums[i]) % k;
			if((i>=1 && sum == 0) || map.containsKey(sum) && map.get(sum) != i-1){ // condition: map.get(sum) != i-1 is important because 2 consecutive nums have to be sum up. check: 1,2,12 k=6 
				return true;
			}
			if(!map.containsKey(sum)) { // this is important
				map.put(sum, i);
			}
		}

		return false;
	}
}
