import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
		//		obj.pacificAtlantic(new int[][] {{1,2},{1,2}});
//		List<List<Integer>> respList = obj.pacificAtlantic(new int[][] {{1,2,3},{8,9,4},{7,6,5}});
		List<List<Integer>> respList = obj.pacificAtlantic(new int[][] {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}});
		System.out.println(respList);
	}

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		List<List<Integer>> respList = new ArrayList<>();
		topMatrix = new boolean[heights.length][heights[0].length];
		bottomMatrix = new boolean[heights.length][heights[0].length];
		
		for(int j=0;j<heights[0].length;j++){
			dfs(heights, 0, j, Integer.MIN_VALUE, topMatrix);
			dfs(heights, heights.length-1, j, Integer.MIN_VALUE, bottomMatrix);
		}
		
		for(int i=0;i<heights.length;i++){
			dfs(heights, i, 0, Integer.MIN_VALUE, topMatrix);
			dfs(heights, i, heights[0].length-1, Integer.MIN_VALUE, bottomMatrix);
		}

		for(int i=0;i<heights.length;i++){
			for(int j=0;j<heights[0].length;j++){
				if(topMatrix[i][j] && topMatrix[i][j] == bottomMatrix[i][j]){
					List<Integer> list = new ArrayList<>(2);
					list.add(i);
					list.add(j);
					respList.add(list);
				}
			}
		}

		return respList;
	}

	private boolean[][] topMatrix = null;
	private boolean[][] bottomMatrix = null;

	private void dfs(int[][] heights, int i, int j, int prev, boolean[][] ocean){
		if(i<0 || i>=heights.length || j<0 || j>=heights[0].length){
			return;
		}

		if(heights[i][j] < prev || ocean[i][j]){
			return;
		}
		
		ocean[i][j] = true;

		dfs(heights, i, j-1, heights[i][j], ocean);            
		dfs(heights, i, j+1, heights[i][j], ocean);            
		dfs(heights, i-1, j, heights[i][j], ocean);            
		dfs(heights, i+1, j, heights[i][j], ocean);            

	}
}
