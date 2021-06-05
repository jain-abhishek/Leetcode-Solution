public class RangeSumofBST {

	public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        helper(root, low, high);
        return sum;
    }
    
    private int sum = 0;
    
    private void helper(TreeNode x, int low, int high){
        if(x == null)
            return;

        if(x.val >= low && x.val <= high)
            sum += x.val;
        
        if(x.val > low)  
            helper(x.left, low, high);
        
        if(x.val < high)
            helper(x.right, low, high);
    }
    
    private static TreeNode root = null;
	
    private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
}
