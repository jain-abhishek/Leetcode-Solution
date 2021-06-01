import java.util.ArrayDeque;

public class ZeroOneMatrix {

	public static void main(String[] args) {
		ZeroOneMatrix obj = new ZeroOneMatrix();
		int[][] resp = obj.updateMatrix(new int[][] {{0,0,0},{0,1,0},{1,1,1}});
		
		for(int i=0;i<resp.length;i++){
			for(int j=0;j<resp[0].length;j++){
				System.out.print(resp[i][j]);
			}
			System.out.println();
		}
	}

	public int[][] updateMatrix(int[][] mat) {
        ArrayDeque<Cell> queue = new ArrayDeque<>();
		int[][] distance = new int[mat.length][mat[0].length];
    
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat[0].length;j++){
				if(mat[i][j] == 0){
                    queue.offer(new Cell(i, j));                
				}
                else{
                    distance[i][j] = Integer.MAX_VALUE;
                }
			}
		}    

        int dist = 0;
        
        while(!queue.isEmpty()){
        	int size = queue.size();
            dist++;
            
            for(int k=0;k<size;k++){
                Cell cell = queue.poll();
				int i = cell.i;
				int j = cell.j;
//				System.out.println(i+" "+j);
                
                if(i-1 >= 0 && mat[i-1][j] == 1){
                	if(dist < distance[i-1][j]) {
                		distance[i-1][j] = dist;
                		queue.offer(new Cell(i-1, j));
                	}
				}
                if(i+1 < mat.length && mat[i+1][j] == 1){
                	if(dist < distance[i+1][j]) {
                		distance[i+1][j] = dist;
                		queue.offer(new Cell(i+1, j));
                	}
				}
                if(j-1 >= 0 && mat[i][j-1] == 1){
                	if(dist < distance[i][j-1]) {
                		distance[i][j-1] = dist;
                        queue.offer(new Cell(i, j-1));
                	}
				}
                if(j+1 < mat[0].length && mat[i][j+1] == 1){
                	if(dist < distance[i][j+1]) {
                		distance[i][j+1] = dist;
                		queue.offer(new Cell(i, j+1));
                	}
				}
            }
        }
        
		return distance;
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
