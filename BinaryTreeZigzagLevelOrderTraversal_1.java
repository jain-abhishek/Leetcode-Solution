import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_1 {

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal_1 tree = new BinaryTreeZigzagLevelOrderTraversal_1();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		tree.root.right.left = new TreeNode(6);
		tree.root.right.right = new TreeNode(7);
		
		tree.root.left.left.left = new TreeNode(8);
		tree.root.left.left.right = new TreeNode(9);
		tree.root.left.right.left = new TreeNode(10);
		tree.root.left.right.right = new TreeNode(11);
		tree.root.right.left.left = new TreeNode(12);
		tree.root.right.left.right = new TreeNode(13);
		tree.root.right.right.left = new TreeNode(14);
		tree.root.right.right.right = new TreeNode(15);
		
		System.out.println(tree.zigzagLevelOrder(tree.root));
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagList = new ArrayList<>();
        
        if(root == null){
            return zigzagList;
        }
            
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        boolean isRight = false;
        queue.offer(root);
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
                
            for(int i=0;i<size;i++){
                TreeNode x = queue.poll();
                if(isRight){
                    stack.push(x);
                }
                else{
                    list.add(x.val);                   
                }
                if(x.left != null){
                    queue.offer(x.left);                        
                }
                if(x.right != null){
                    queue.offer(x.right);                        
                }
            }
            isRight = !isRight;
            while(!stack.isEmpty()){
                list.add(stack.pop().val);
            }
            zigzagList.add(list);
        }
        
        return zigzagList;
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
