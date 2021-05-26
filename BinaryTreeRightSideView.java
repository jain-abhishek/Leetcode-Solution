import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		
		BinaryTreeRightSideView obj = new BinaryTreeRightSideView();
		List<Integer> resp = obj.rightSideView(root);
		System.out.println(resp);
	}

	public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        List<Integer> rightSideView = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        boolean flag = false;
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode x = queue.poll();
                if(!flag)
                    rightSideView.add(x.val);
                flag = true;
                if(x.right != null)
                    queue.offer(x.right);
                if(x.left != null)
                    queue.offer(x.left);
            }
            flag = false;
        }
        
        return rightSideView;
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
