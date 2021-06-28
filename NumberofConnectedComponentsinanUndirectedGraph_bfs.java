// dfs is faster
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class NumberofConnectedComponentsinanUndirectedGraph_bfs {

	public static void main(String[] args) {
		NumberofConnectedComponentsinanUndirectedGraph_bfs obj = new NumberofConnectedComponentsinanUndirectedGraph_bfs();
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
				bfs(graph, v, visited);
				connectedComponents++;
			}
		}

		return connectedComponents;
	}

	private void bfs(List<List<Integer>> graph, int v, boolean[] visited){
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(v);
		visited[v] = true;

		while(!queue.isEmpty()){
			v = queue.poll();
			List<Integer> adj = graph.get(v);
			for(int vert : adj){
				if(!visited[vert]){ // this is important
					queue.offer(vert);
					visited[vert] = true;
				}
			}
		}
	} 
}
