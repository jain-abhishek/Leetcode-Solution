public class FlippingImage {

	public static int[][] flipAndInvertImage(int[][] a) {
		if(a==null || a.length==0 || a[0] == null || a[0].length == 0)
			return a;

		int j=0;
		int k=a[0].length-1;

		for(int i=0;i<a.length;i++){
			j=0;
			k=a[0].length-1;
			while(j<=k){
				if(j==k){
					a[i][j] = a[i][j] == 1 ? 0 : 1;  
				}
				else if(a[i][j] == a[i][k]){
					a[i][j] = (a[i][j] == 1 ? 0 : 1);  
					a[i][k] = (a[i][k] == 1 ? 0 : 1);  
				}

				j++;
				k--;
			}
		}

		return a;
	}
}
