public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		ValidateBinarySearchTree tree = new ValidateBinarySearchTree();
		tree.root = new TreeNode(5);
		tree.root.left = new TreeNode(1);
		tree.root.right = new TreeNode(7);
		tree.root.right.left = new TreeNode(3);
		tree.root.right.right = new TreeNode(8);
		
		System.out.println(tree.isValidBST(tree.root));
		
		tree.root = new TreeNode(Integer.MIN_VALUE);
		System.out.println(tree.isValidBST(tree.root));
		
	}

	public boolean isValidBST(TreeNode root) {
		max = (long)Integer.MIN_VALUE-1;
		found = false;
		preOrderTraverse(root);

		return !found;
	}    

	private static long max = (long)Integer.MIN_VALUE-1; // this is important
	private static boolean found = false;

	private void preOrderTraverse(TreeNode x){
		if(x == null){
			return;
		}
		if(!found){
			preOrderTraverse(x.left);
		}

		if(x.val <= max){
			found = true;
		}
		else{    
			max = x.val;
		}

		if(!found){
			preOrderTraverse(x.right);
		}
	}

	private TreeNode root = null;
	private static class TreeNode {
		private int val;
		
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
