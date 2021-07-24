// working, but LongestConsecutiveSequence_1 is faster

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
		System.out.println(obj.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
		System.out.println(obj.longestConsecutive(new int[]{100,4,200,1,3,2}));
		System.out.println(obj.longestConsecutive(new int[]{100,0,200,-1,3,2,1}));
		System.out.println(obj.longestConsecutive(new int[]{100,0,200,3,5}));
		System.out.println(obj.longestConsecutive(new int[]{}));
	}

	public int longestConsecutive(int[] nums) {
		HashMap<Integer, Integer> root = new HashMap<>();
		HashMap<Integer, Integer> size = new HashMap<>();

		for(int i=0;i<nums.length;i++){
			if(!root.containsKey(nums[i])) {
				root.put(nums[i], nums[i]);
				size.put(nums[i], 1);

				if(root.containsKey(nums[i]-1)) {
					int root1 = findRoot(nums[i], root);
					int root2 = findRoot(nums[i]-1, root);
					if(root1 != root2) {
						if(size.get(root2) >= size.get(root1)) {
							root.put(root1, root2);
							size.put(root2, size.get(root1) + size.get(root2));
						}
						else {
							root.put(root2, root1);
							size.put(root1, size.get(root1) + size.get(root2));							
						}
					}
				}
				if(root.containsKey(nums[i]+1)) {
					int root1 = findRoot(nums[i], root);
					int root2 = findRoot(nums[i]+1, root);
					if(root1 != root2) {
						if(size.get(root2) >= size.get(root1)) {
							root.put(root1, root2);
							size.put(root2, size.get(root1) + size.get(root2));
						}
						else {
							root.put(root2, root1);
							size.put(root1, size.get(root1) + size.get(root2));							
						}
					}
				}
			}
		}

		HashMap<Integer, Integer> counts = new HashMap<>();
		
		for(Map.Entry<Integer, Integer> entry : root.entrySet()) {
			int root1 = findRoot(entry.getKey(), root);
			root.put(entry.getKey(), root1);
			counts.put(root1, counts.getOrDefault(root1, 0)+1);
		}

		int max = 0;
		for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
			max = Math.max(entry.getValue(), max);
		}
		
		return max;
	}

	private int findRoot(int num, HashMap<Integer, Integer> root){
		if(!root.containsKey(num)) {
			return num;
		}

		while(num != root.get(num)) {
			root.put(num, root.get(root.get(num)));
			num = root.get(num);
		}

		return num;
	}

}
