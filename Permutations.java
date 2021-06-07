import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		Permutations obj = new Permutations();
		List<List<Integer>> resp = obj.permute(new int[] {1,2,3,4,5,6});
		System.out.println(resp);
		resp = obj.permute(new int[] {1,2,3});
		System.out.println(resp);
		resp = obj.permute(new int[] {1});
		System.out.println(resp);
	}

	private boolean[] visited = null;
    List<List<Integer>> permutationList = null;
    
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];    
        permutationList = new ArrayList<>();
        
        helper(nums, new ArrayList<>());        
        return permutationList;        
    }
    
    
    private void helper(int[] nums, List<Integer> list){
        if(list.size() == nums.length){
            List<Integer> l = new ArrayList<>(list);
            permutationList.add(l);
            return;    
        }
        
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                helper(nums, list);
                visited[i] = false;
                list.remove(list.size()-1);
            }    
        }
    }
}
