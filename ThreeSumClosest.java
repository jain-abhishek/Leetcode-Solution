import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		ThreeSumClosest obj = new ThreeSumClosest();
		
		System.out.println(obj.threeSumClosest(new int[] {-4, -2, -1, -1, 1, 2, 3}, 5));
	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int k;
		int j;
		int minDiff = Integer.MAX_VALUE;

		for(int i=0;i<nums.length-2;i++){
			j = i+1;
			k = nums.length-1;
			while(j<k){
				int sum = nums[i]+nums[j]+nums[k];
				
				if(sum == target)            
					return sum;
				else if(sum < target){
					if(Math.abs(minDiff) > Math.abs(target-sum)) {
						minDiff = target-sum;
					}
					j++;
				}
				else{
					if(Math.abs(minDiff) > Math.abs(target-sum)) {
						minDiff = target-sum;
					}
					k--;
				}
			}
		}

		return target-minDiff;
	}
}
