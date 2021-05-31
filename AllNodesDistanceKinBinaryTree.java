import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllNodesDistanceKinBinaryTree {

	public static void main(String[] args) {
		AllNodesDistanceKinBinaryTree obj = new AllNodesDistanceKinBinaryTree();
		
		obj.root = new TreeNode(9);
		obj.root.left = new TreeNode(3);
		obj.root.right = new TreeNode(8);
		obj.root.left.left = new TreeNode(5);
		obj.root.left.right = new TreeNode(1);
		obj.root.left.left.left = new TreeNode(6);
		obj.root.left.left.right = new TreeNode(2);
		obj.root.left.left.right.left = new TreeNode(7);
		obj.root.left.left.right.right = new TreeNode(4);

		List<Integer> list = obj.distanceK(obj.root, obj.root.left.left, 2);
		System.out.println(list);
		
		list = obj.distanceK(obj.root, obj.root.left.left, 3);
		System.out.println(list);
	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		Map<TreeNode, TreeNode> parentMap = new HashMap<>();
		List<Integer> list = new ArrayList<>();

		ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		TreeNode x = root;

		parentMap.put(x, null);

		queue.offer(x);

		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				x = queue.poll();
				if(x.left != null) {
					queue.offer(x.left);
					parentMap.put(x.left, x);
				}
				if(x.right != null) {
					queue.offer(x.right);
					parentMap.put(x.right, x);
				}
			}
		}

		//		bfs
		int distance = 0;
		Set<TreeNode> visited = new HashSet<>();

		queue.offer(target);
		visited.add(target); 

		while(!queue.isEmpty()) {
			int size = queue.size();
			if(distance == k) {
				while(!queue.isEmpty()) {
					list.add(queue.poll().val);
				}
				break;
			}
			else {
				for(int i=0;i<size;i++) {
					x = queue.poll();
					if(x.left != null && !visited.contains(x.left)) {
						queue.offer(x.left);
						visited.add(x.left);
					}
					if(x.right != null && !visited.contains(x.right)) {
						queue.offer(x.right);
						visited.add(x.right);
					}
	
					TreeNode parent = parentMap.get(x);
	
					if(parent != null && !visited.contains(parent)) {
						queue.offer(parent);
						visited.add(parent);
					}
				}
			}
			distance++;
		}

		return list;
	}

	TreeNode root = null;

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x; 
		}
	}
}




