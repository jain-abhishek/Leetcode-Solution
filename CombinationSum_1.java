import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CombinationSum_1 {

	public static void main(String[] args) {
		CombinationSum_1 obj = new CombinationSum_1();
		System.out.println(obj.combinationSum(new int[] {2,3,6,7}, 7));
		System.out.println(obj.combinationSum(new int[] {2}, 1));
		System.out.println(obj.combinationSum(new int[] {1}, 2));
	}

	public List<List<Integer>> combinationSum(int[] cand, int target) {
		List<List<Integer>> respList = new ArrayList<>();
		Map<Integer, Set<List<Integer>>> map = new HashMap<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(target);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int n = queue.poll();
                if(n == 0){
                    continue;
                }
                for(int c : cand){
                    if(n-c >= 0){
                        queue.offer(n-c);
                        
                        Set<List<Integer>> masterList = null;
                        Set<List<Integer>> mList = null;
                        
                        if(map.containsKey(n)){
                            mList = map.get(n);
                            for(List<Integer> lst : mList){
                            	List<Integer> list = new ArrayList<>();
                            	for(int m :lst) {
                            		list.add(m);
                            	}
                                list.add(c);
                                if(!map.containsKey(n-c)){
                                    masterList = new HashSet<>();
                                }
                                else{
                                    masterList = map.get(n-c);
                                }
                                masterList.add(list);
                            }
                        }
                        else{
                            List<Integer> list = new ArrayList<>();
                            list.add(c);
                            if(!map.containsKey(n-c)){
                                masterList = new HashSet<>();
                            }
                            else{
                                masterList = map.get(n-c);
                            }
                            masterList.add(list);
                        }
                        // System.out.println(n-c);
                        map.put(n-c, masterList);
                    }
                }
            }
        }
        
        Set<List<Integer>> respSet = map.get(0);
        if(respSet == null)
        	return respList;
        
        Map<String, List<Integer>> tempMap = new HashMap<>();
        for(List<Integer> list : respSet) {
        	Collections.sort(list);
        	StringBuilder sb = new StringBuilder();
        	for(int i : list) {
        		sb.append(i);
        	}
        	tempMap.put(sb.toString(), list);
        }
        
        for(List<Integer> list : tempMap.values()) {
        	respList.add(list);
        }
        
        return respList;
	}
}
