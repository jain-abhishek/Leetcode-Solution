// working: sliding window (aka 2 pointers) 

package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(obj.lengthOfLongestSubstring("pwwkeapawbcdefg"));
		System.out.println(obj.lengthOfLongestSubstring("bbbba"));
		System.out.println(obj.lengthOfLongestSubstring("bbbb"));
		System.out.println(obj.lengthOfLongestSubstring("b"));
		System.out.println(obj.lengthOfLongestSubstring(""));
		System.out.println(obj.lengthOfLongestSubstring("advdfk"));
		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(obj.lengthOfLongestSubstring("tmmzt"));
	}

	private static Set<Character> set = new HashSet<>(); 
	
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		set.clear();
		int max = Integer.MIN_VALUE;
        int j = 0;
        int len = 0;
        int i=0;
        
        while(i<s.length() && j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));  
                len = j-i+1;
                j++;
            }
            else{
            	set.remove(s.charAt(i));
                i++;
            }
            if(len>max)
                max = len;
        }
        
		return max;
    }
}
