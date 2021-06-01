import java.util.ArrayDeque;

public class ZeroOneMatrix_1 {

	public static void main(String[] args) {
		ZeroOneMatrix_1 obj = new ZeroOneMatrix_1();
		int[][] resp = obj.updateMatrix(new int[][] {{0,0,0},{0,1,0},{1,1,1}});
		
		for(int i=0;i<resp.length;i++){
			for(int j=0;j<resp[0].length;j++){
				System.out.print(resp[i][j]);
			}
			System.out.println();
		}
	}

	int[][] distance = null;
	boolean[][] visited = null;

	public int[][] updateMatrix(int[][] mat) {
		distance = new int[mat.length][mat[0].length];
		visited = new boolean[mat.length][mat[0].length];

		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				if(mat[i][j] == 1){
					bfs(mat, i, j);
					visited[i][j] = true;
				}
			}
		}    

		return distance;
	}

	private void bfs(int[][] mat, int i, int j){
		ArrayDeque<Cell> queue = new ArrayDeque<>();
		queue.offer(new Cell(i, j));
		int dist = 0;
		boolean flag = false;
        
        int minDist = Integer.MAX_VALUE;
        
		while(!queue.isEmpty()){
			int size = queue.size();
			dist++;

			for(int k=0;k<size;k++){
				Cell cell = queue.poll();
				int tempI = cell.i;
				int tempJ = cell.j;

				if(visited[tempI][tempJ]){
                    minDist = distance[tempI][tempJ] + dist;
				}

				if(tempI-1 >= 0 && mat[tempI-1][tempJ] == 0){
					distance[i][j] = Math.min(dist, minDist);
					flag = true;
					break;
				}
				else{
					if(tempI-1 >= 0)
						queue.offer(new Cell(tempI-1, tempJ));
				}
				if(tempI+1 < mat.length && mat[tempI+1][tempJ] == 0){
					distance[i][j] = Math.min(dist, minDist);
					flag = true;
					break;
				}
				else{
					if(tempI+1 < mat.length)
						queue.offer(new Cell(tempI+1, tempJ));
				}
				if(tempJ-1 >=0 && mat[tempI][tempJ-1] == 0){
					distance[i][j] = Math.min(dist, minDist);
					flag = true;
					break;
				}
				else{
					if(tempJ-1 >= 0)
						queue.offer(new Cell(tempI, tempJ-1));
				}
				if(tempJ+1 < mat[0].length && mat[tempI][tempJ+1] == 0){
					distance[i][j] = Math.min(dist, minDist);
					flag = true;
					break;
				}
				else{
					if(tempJ+1 < mat[0].length)
						queue.offer(new Cell(tempI, tempJ+1));
				}
			}
			if(flag){
				flag = false;
				break;
			}
		}
	}

	private static class Cell{
		int i;
		int j;

		public Cell(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}
