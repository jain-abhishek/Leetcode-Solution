public class MergeTwoBinaryTrees {

	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(1);
		tree1.left = new TreeNode(3);
		tree1.right = new TreeNode(2);
		tree1.left.left = new TreeNode(5);

		TreeNode tree2 = new TreeNode(2);
		tree2.left = new TreeNode(1);
		tree2.right = new TreeNode(3);
		tree2.left.right = new TreeNode(4);
		tree2.right.right = new TreeNode(7);

		MergeTwoBinaryTrees obj = new MergeTwoBinaryTrees();

		obj.mergeTrees(tree1, tree2);
	}

	public TreeNode mergeTrees(TreeNode x, TreeNode y) {
		if(x == null)
			return y;
		if(y == null)
			return x;

		x.val += y.val;

		x.left = mergeTrees(x.left, y.left);
		x.right = mergeTrees(x.right, y.right);            

		return x;
	}

}









