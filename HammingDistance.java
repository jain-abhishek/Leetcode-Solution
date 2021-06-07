public class HammingDistance {

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
		System.out.println(hammingDistance(8, 7));
		System.out.println(hammingDistance(15, 4));
		
		System.out.println(hammingDistance1(15, 4));
		System.out.println(hammingDistance1(8, 7));
		System.out.println(hammingDistance1(1, 4));
		
		System.out.println(hammingDistance2(1, 4));
		System.out.println(hammingDistance2(8, 7));
		System.out.println(hammingDistance2(15, 4));
	}

	public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y); 
    }
	
	public static int hammingDistance1(int x, int y){
		int n = x^y;
		int count = 0;
		
		while(n!=0) {
			if(n%2 == 1)
				count++;
			n = n/2;
		}
		return count;
	}
	
	public static int hammingDistance2(int x, int y) {

		byte[] xa = new byte[32];
		byte[] ya = new byte[32];

		int i = 31;
		while(x!=0){
			xa[i--] = (byte) (x%2);
			x = x/2;
		}

		int j = 31;
		while(y!=0){
			ya[j--] = (byte) (y%2);    
			y = y/2;
		}

		int count = 0;
		for(int k = 0;k<32;k++){
			if(xa[k] != ya[k])
				count++;
		}

		return count;
	}
	
	public static int hammingDistance3(int x, int y) {
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);
        int i = s1.length();
        int j = s2.length();
        
        int hammingDistance = 0;
        
        while(i != 0 && j != 0){
            if(s1.charAt(i-1) != s2.charAt(j-1)){
                hammingDistance++;  
            }
            i--;
            j--;

        }
        
        if(i != 0){
            while(i != 0){
                if(s1.charAt(i-1) == '1'){
                    hammingDistance++;  
                }
                i--;
            }
        }
        if(j != 0){
             while(j != 0){
                if(s2.charAt(j-1) == '1'){
                    hammingDistance++;  
                }
                j--;
            }
        }
        
        return hammingDistance;
    }
}
