//working: 100%: 2D-prefixSum

public class MatrixBlockSum_1314 {

	public static void main(String[] args) {
//		int[][] ans = matrixBlockSum(new int[][] {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}}, 2);
//		int[][] ans = matrixBlockSum(new int[][] {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}}, 2);
//		int[][] ans = matrixBlockSum(new int[][] {{1,2,3},{1,2,3},{1,2,3},{1,2,3},{1,2,3}}, 2);
		int[][] ans = matrixBlockSum(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, 1);
		
		for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
            	System.out.print(ans[i][j]+",");
            }
            System.out.println();
        }
	}
	
	public static int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] ans = new int[mat.length][mat[0].length];
        
        int[][] prefixSumRow = new int[mat.length][mat[0].length];
        
        for(int i=0;i<mat.length;i++){
        	prefixSumRow[i][0] = mat[i][0]; 
        }
        
        for(int i=0;i<mat.length;i++){
            for(int j=1;j<mat[0].length;j++){
                prefixSumRow[i][j] = mat[i][j] + prefixSumRow[i][j-1];
            }
        }
        
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int minR = i-k < 0 ? 0 : i-k;
                int maxR = i+k >= mat.length ? mat.length-1 : i+k;
                
                int minC = j-k;
                int maxC = j+k >= mat[0].length ? mat[0].length-1 : j+k;
                
                int sum = 0;
                for(int m=minR;m<=maxR;m++){
                	if(minC>0) {
                		sum = sum + (prefixSumRow[m][maxC] - prefixSumRow[m][minC-1]);
                	}
                	else {
                		sum = sum + prefixSumRow[m][maxC];
                	}
                }    
                
                ans[i][j] = sum;
            }
        }
        
        return ans;
    }

}
