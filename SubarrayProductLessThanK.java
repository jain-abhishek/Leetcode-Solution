// trick is: i-j+1
// for 2,3,4,5, k=100:  
// for i=0, j=0 prod=2 which is less than 100, so i-j+1 = 1 so the pair: {2}
// for i=0, j=1 prod=6 which is less than 100, so i-j+1 = 2 so the pair: {{2,3},{3}}
// for i=0, j=2 prod=24 which is less than 100, so i-j+1 = 3 so the pair: {{2,3,4},{3,4},{4}}
// for i=0, j=3 prod=120 which is greater than 100, so have to increment i. now prod=60  i-j+1 = 3 so the pair: {{3,4,5},{4,5},{5}}

public class SubarrayProductLessThanK {

	public static void main(String[] args) {
		System.out.println(numSubarrayProductLessThanK(new int[] {2,3,4,5}, 100));
	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		int i=0;
		int j=0;
		int prod = 1;

		int count = 0;

		for(i=0;i<nums.length;i++){
			prod = prod * nums[i];
			while(prod >= k){
				prod = prod / nums[j];
				j++;
			}
			count = count + i - j + 1; // this is the trick
		}

		return count;
	}
}
