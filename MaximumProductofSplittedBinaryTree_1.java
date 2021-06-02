// working: slower than other, but easier to code and understand

import java.util.ArrayList;
import java.util.List;

public class MaximumProductofSplittedBinaryTree_1 {

	public static void main(String[] args) {
		MaximumProductofSplittedBinaryTree_1 obj = new MaximumProductofSplittedBinaryTree_1();
		
		obj.root = new TreeNode(1);
		obj.root.left = new TreeNode(2);
		obj.root.right = new TreeNode(3);
		obj.root.left.left = new TreeNode(4);
		obj.root.left.right = new TreeNode(5);
		obj.root.right.left = new TreeNode(6);
		
		System.out.println(obj.maxProduct(obj.root));
	}

	public int maxProduct(TreeNode root) {
        postOrderTrav(root);
        
        long totalSum = root.val;
        long best = 0;
        for (int sum : allSums) { 
            best = Math.max(best, (long) sum * (totalSum - sum)); // making sum as long is important
        }
        return (int)(best % 1000000007);
    }

    private List<Integer> allSums = new ArrayList<>();

    private int postOrderTrav(TreeNode x){
        if(x == null){
            return 0;
        }
        
        int left = postOrderTrav(x.left);
        int right = postOrderTrav(x.right);
        
        x.val += left + right;
        
        allSums.add(x.val);
        
        return x.val;
    }

	TreeNode root = null;
	public static class TreeNode {
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
