import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum obj = new CombinationSum();
		System.out.println(obj.combinationSum(new int[] {1,2}, 4));
		
		System.out.println(obj.combinationSum(new int[] {2,3,6,7}, 7));
		System.out.println(obj.combinationSum(new int[] {2,3,6,7}, 6));
		System.out.println(obj.combinationSum(new int[] {1}, 1));
		System.out.println(obj.combinationSum(new int[] {1}, 2));
		System.out.println(obj.combinationSum(new int[] {2}, 1));
	}

	private boolean[][] memo = null;
	private List<List<Integer>> respList = null;

	public List<List<Integer>> combinationSum(int[] c, int target) {
		respList = new ArrayList<>();

		memo = new boolean[c.length+1][target+1];
		for(int i=0;i<c.length+1;i++) {
			for(int j=0;j<target+1;j++) {
				if(j==0 && i!=0)
					memo[i][j] = true;
			}
		}
		for(int i=1;i<c.length+1;i++) {
			for(int j=1;j<target+1;j++) {
				if(j >= c[i-1]) {
					memo[i][j] = memo[i][j-c[i-1]] || memo[i-1][j];
				}
				else {
					memo[i][j] = memo[i-1][j];
				}
			}
		}

		//		return memo[c.length][target];
		
		findCombinations(c, c.length, target, new ArrayList<>(), false);

		return respList;

	}

	private void findCombinations(int[] c, int i, int j, List<Integer> list, boolean isLeft){
//		System.out.println(i +" "+ j);
		if(!memo[i][j]) {
			return;
		}
		
		if(j==0 || isLeft) {
			list.add(c[i-1]);
			if(j==0) { // we will add only when we reach to 0th column, because here only we found a solution
				List<Integer> tempList = new ArrayList<>(list);
				respList.add(tempList);
			}
		}
		
		if(j-c[i-1] >=0 && memo[i][j-c[i-1]]) {
			List<Integer> l = new ArrayList<>();
			for(int n : list)
				l.add(n);
			findCombinations(c, i, j-c[i-1], l, true);
		}
		if(i-1>=0 && j>=1) {
			List<Integer> l = new ArrayList<>();
			for(int n : list)
				l.add(n);
			findCombinations(c, i-1, j, l, false);
		}
	}
}
