public class FindtheDuplicateNumber {

	public static void main(String[] args) {
		FindtheDuplicateNumber obj = new FindtheDuplicateNumber();
//		System.out.println(obj.findDuplicate(new int[] {3,1,3,4,2}));
//		System.out.println(obj.findDuplicate(new int[] {3,1,5,4,2,2,2,2}));
		System.out.println(obj.findDuplicate(new int[] {2,5,9,6,9,3,8,9,7,1}));
	}

	public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		do {
			slow = nums[slow];
			fast = nums[nums[fast]];
		} while (slow != fast);

		slow = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}

		return fast;
	}

}
