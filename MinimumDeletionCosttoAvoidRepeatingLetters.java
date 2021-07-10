
public class MinimumDeletionCosttoAvoidRepeatingLetters {

	public static void main(String[] args) {
		MinimumDeletionCosttoAvoidRepeatingLetters obj = new MinimumDeletionCosttoAvoidRepeatingLetters();
		System.out.println(obj.minCost("aaaaabaaaaa", new int[] {1,2,3,4,5,6,5,4,3,2,1}));
		System.out.println(obj.minCost("aaaaabaaaaa", new int[] {5,4,3,2,1,6,1,2,3,4,5}));
		System.out.println(obj.minCost("aa", new int[] {5,4}));
		System.out.println(obj.minCost("aa", new int[] {4,5}));
		System.out.println(obj.minCost("ab", new int[] {5,4}));
	}

	public int minCost(String s, int[] cost) {
		int i=0;
		int j=1;
		int minCost = 0;

		while(j != s.length()){
			if(s.charAt(i) != s.charAt(j)){
				i = j;
			}
			else{
				if(cost[i] > cost[j]){
					minCost += cost[j];
				}
				else{
					minCost += cost[i];
					i = j;
				}
			}
			j++;
		}

		return minCost;
	}
}
