public class SquaresOfASortedArray {

	public static void main(String[] args) {
		int[] resp = sortedSquares(new int[] {-4,-1,0,3,10});
		for(int n : resp) {
			System.out.println(n);
		}
		resp = sortedSquares(new int[] {-4,-3,-2,-1});
		for(int n : resp) {
			System.out.println(n);
		}
		resp = sortedSquares(new int[] {1,2,3,4});
		for(int n : resp) {
			System.out.println(n);
		}
		resp = sortedSquares(new int[] {-1});
		for(int n : resp) {
			System.out.println(n);
		}
	}	

	public static int[] sortedSquares(int[] nums) {
		int[] resp = new int[nums.length];
        
        int min = Math.abs(nums[0]);
        int i = 0;
        for(i=1;i<nums.length;i++){
            if(Math.abs(nums[i]) <= min){
                min = Math.abs(nums[i]);
            }
            else{
                break;
            }
        }
        
        i--;
        int n = 0;
        int j = i+1;
        int k = i-1;
        
        resp[n] = nums[i] * nums[i];
        
        while(j < nums.length && k >= 0){
            if(Math.abs(nums[k]) <= Math.abs(nums[j])){
                resp[++n] = nums[k] * nums[k];
                k--;
            }
            else{
                resp[++n] = nums[j] * nums[j];
                j++;
            }
        }
        
        if(j < nums.length){
            while(j != nums.length){
                resp[++n] = nums[j] * nums[j];
                j++;
            }
        }
        else if(k >= 0){
            while(k >= 0){
                resp[++n] = nums[k] * nums[k];
                k--;
            }
        }

        return resp;
    }
}