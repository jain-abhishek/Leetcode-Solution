// 1,0,1,2,-1 is an imp test case which tells why map value has to be incremented

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		SubarraySumEqualsK obj = new SubarraySumEqualsK();
		System.out.println(obj.subarraySum(new int[] {1,1,1}, 2)); //2
		System.out.println(obj.subarraySum(new int[] {-1,1,1,1,1,2}, 2)); //5
		System.out.println(obj.subarraySum(new int[] {1,2,1,2,1}, 3)); //4
		System.out.println(obj.subarraySum(new int[] {1,0,1,2,-1}, 2)); //4 
		System.out.println(obj.subarraySum(new int[] {10,5,7,1,2,5,3}, 15)); //3  
	}

	private Map<Integer, Integer> map = null;
	public int subarraySum(int[] a, int k) {
		if(a.length == 0)
			return 0;

		int counter = 0;
		int sum = 0;
		map = new HashMap<>(a.length);
		map.put(0, 1);
		
		for(int i=0;i<a.length;i++) {
			sum = sum + a[i];
			
//			if(sum == k)  // by putting 0 into map,l there is no need of checking it
//				counter++; 
			
			if(map.containsKey(sum-k))
				counter = counter + map.get(sum-k);
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		
		return counter;
	}
}
