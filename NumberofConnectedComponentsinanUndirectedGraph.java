// dfs is faster
import java.util.ArrayList;
import java.util.List;

public class NumberofConnectedComponentsinanUndirectedGraph {

	public static void main(String[] args) {
		NumberofConnectedComponentsinanUndirectedGraph obj = new NumberofConnectedComponentsinanUndirectedGraph();
		System.out.println(obj.countComponents(2, new int[][] {{0,1}}));
		System.out.println(obj.countComponents(5, new int[][] {{0,1}, {1,2}, {3,4}}));
		System.out.println(obj.countComponents(3, new int[][] {{0,1}, {1,2}, {2,0}}));
		System.out.println(obj.countComponents(9, new int[][] {{0,1},{1,2},{2,0},{3,4},{4,5},{5,3},{6,7},{7,8},{8,0}}));
	}

	public int countComponents(int n, int[][] edges) {
		if(n == 1)
			return 1;

		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0;i<n;i++){
			graph.add(new ArrayList<Integer>());
		}

		for(int j=0;j<edges.length;j++){
			List<Integer> adj = graph.get(edges[j][0]);
			adj.add(edges[j][1]);
			adj = graph.get(edges[j][1]); // this is important
			adj.add(edges[j][0]);
		}

		boolean[] visited = new boolean[graph.size()];

		int connectedComponents = 0;

		for(int v=0;v<graph.size();v++){
			if(!visited[v]){
				dfs(graph, v, visited);
				connectedComponents++;
			}
		}

		return connectedComponents;
	}

	private void dfs(List<List<Integer>> graph, int v, boolean[] visited){
		List<Integer> vertices = graph.get(v);
		for(int vert : vertices) {
			if(!visited[vert]) {
				visited[vert] = true;
				dfs(graph, vert, visited);
			}
		}
	}
}
