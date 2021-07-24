import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_1 {

	public static void main(String[] args) {
		LongestConsecutiveSequence_1 obj = new LongestConsecutiveSequence_1();
		System.out.println(obj.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
		System.out.println(obj.longestConsecutive(new int[]{100,4,200,1,3,2}));
		System.out.println(obj.longestConsecutive(new int[]{100,0,200,-1,3,2,1}));
		System.out.println(obj.longestConsecutive(new int[]{100,0,200,3,5}));
	}

	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();

		for (int num : nums) {
			set.add(num);
		}

		int maxCount = 0;

		for(int num : set){
			if(!set.contains(num-1)){
				int count = 1;

				while(set.contains(num+1)){
					num += 1;
					count += 1; 
				}

				maxCount = Math.max(count, maxCount);
			}
		}

		return maxCount;            
	}
}
