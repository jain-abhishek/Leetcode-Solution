import java.util.ArrayDeque;

public class MergeTwoBinaryTrees_1 {

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
		
		MergeTwoBinaryTrees_1 obj = new MergeTwoBinaryTrees_1();
		
		obj.mergeTrees(tree1, tree2);
	}

	public TreeNode mergeTrees(TreeNode xRoot, TreeNode y) {
		ArrayDeque<TreeNode> queue1 = new ArrayDeque<>();
		ArrayDeque<TreeNode> queue2 = new ArrayDeque<>();
		TreeNode x = xRoot;
		
		queue1.offer(x);
		queue2.offer(y);

		while(!queue1.isEmpty() && !queue2.isEmpty()){
			int size = queue1.size();

			for(int i=0;i<size;i++){
				x = queue1.poll();
				y = queue2.poll();
				x.val = x.val + y.val;

				if(x.left != null && y.left != null){
					queue1.offer(x.left);
					queue2.offer(y.left);
				}

				else if(x.left == null && y.left != null){
					x.left = y.left;
				}

				if(x.right != null && y.right != null){
					queue1.offer(x.right);
					queue2.offer(y.right);
				}

				else if(x.right == null && y.right != null){
					x.right = y.right;                
				}
			}
		}

		return xRoot;
	}
}

class TreeNode {
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







