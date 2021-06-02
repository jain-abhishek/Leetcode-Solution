// working: faster than other soln
public class MaximumProductofSplittedBinaryTree {

	public static void main(String[] args) {
		MaximumProductofSplittedBinaryTree obj = new MaximumProductofSplittedBinaryTree();
		
		obj.root = new TreeNode(1);
		obj.root.left = new TreeNode(2);
		obj.root.right = new TreeNode(3);
		obj.root.left.left = new TreeNode(4);
		obj.root.left.right = new TreeNode(5);
		obj.root.right.left = new TreeNode(6);
		
		System.out.println(obj.maxProduct(obj.root));
	}

	public int maxProduct(TreeNode root) {
        maxProduct = 0;
        postOrderTrav(root);
        trav(root, root.val);

        return (int) (maxProduct % 1000000007);
    }

    private int postOrderTrav(TreeNode x){
        if(x == null){
            return 0;
        }
        
        int left = postOrderTrav(x.left);
        int right = postOrderTrav(x.right);
        
        x.val += left + right;
        
        return x.val;
    }
    
    private static long maxProduct = 0;
    
    private void trav(TreeNode x, int rootValue){
        if(x == null){
            return;
        }
        
        long product = (long) x.val * (rootValue - x.val); // converting x.val as long is important
        maxProduct = Math.max(product, maxProduct);
        
        trav(x.left, rootValue);        
        trav(x.right, rootValue);
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
