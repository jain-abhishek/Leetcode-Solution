public class SubarraySumsDivisiblebyK_974 {
	public static void main(String[] args) {
		SubarraySumsDivisiblebyK_974 obj = new SubarraySumsDivisiblebyK_974();
		System.out.println(obj.subarraysDivByK(new int[] {2,-6,3,1,2,8,2,1}, 5));
		System.out.println(obj.subarraysDivByK(new int[] {2,-6,3,1,2,8,2,1}, 7));
		System.out.println(obj.subarraysDivByK(new int[] {4,5,0,-2,-3,1}, 5));
		System.out.println(obj.subarraysDivByK(new int[] {-100,5,0,0,5,1,2,2}, 5));
		System.out.println(obj.subarraysDivByK(new int[] {8,9,7,8,9}, 8));
	}

	public int subarraysDivByK(int[] nums, int k) {
        int[] freq = new int[k];
		int runningSum = 0;
		freq[0] = 1;
        
		for(int i=0;i<nums.length;i++){
			runningSum = (runningSum + nums[i]) % k;
			if(runningSum < 0) { 
				runningSum = runningSum + k;
			}
            freq[runningSum] = freq[runningSum]+1; 
		}

		int count = 0;
		for(int n : freq){
            if(n == 2){
                count++;
            }
            else if(n > 2){
                count += (n * (n-1))/2; 
            }
		}
		return count; 
    }
}
