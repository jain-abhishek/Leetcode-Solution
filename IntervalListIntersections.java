import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

	public static void main(String[] args) {
		IntervalListIntersections obj = new IntervalListIntersections();
		 
		int[][] resp = obj.intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}}, new int[][]{{1,5},{8,12},{15,24},{25,26}});
		for(int[] interval : resp) {
			System.out.println(interval[0] + " "+ interval[1]);
		}
	}
	
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		List<int[]> list = new ArrayList<>();

		if(firstList.length == 0) {
			return firstList;
		}

		if(secondList.length == 0){
			return secondList;
		}

		int i=0;
		int j=0;

		while(i != secondList.length && j != firstList.length){
			if(secondList[i][0] < firstList[j][0]){
				if(secondList[i][1] < firstList[j][0]){
					i++;
				}
				else{
					int[] inter = new int[2];
					inter[0] = firstList[j][0];
					inter[1] = Math.min(firstList[j][1], secondList[i][1]);

					if(firstList[j][1] < secondList[i][1]){
						j++;
					}
					else{
						i++;
					}

					list.add(inter);
				}
			}
			else{
				if(secondList[i][0] > firstList[j][1]){
					j++;
				}
				else{
					int[] inter = new int[2];
					inter[0] = secondList[i][0];
					inter[1] = Math.min(firstList[j][1], secondList[i][1]);

					if(firstList[j][1] < secondList[i][1]){
						j++;
					}
					else{
						i++;
					}
					list.add(inter);
				}
			}

		}

		int[][] resp = new int[list.size()][];
		for(int k=0;k<list.size();k++){
			resp[k] = list.get(k);
		}

		return resp;
	}

}
