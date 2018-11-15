package pers.dingjie.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description : 给定一个字符串，找出不含有重复字符的最长子串的长度
 * @author      : dingjie
 * @date 	    : 2018年9月3日 下午6:17:48 
 */
public class Longest_substring_without_repeating_characters {
	
	/**
	 * @description 暴力法
	 */
	public int lengthOfLongestSubstring_1(String s) {
		int maxLength = 0;
			
		for (int i = 0; i < s.length(); i++) {
			for (int j = i+1; j <= s.length(); j++) {
				HashSet<Character> hashSet = new HashSet<Character>();
				boolean flag = true;
				for (int k = i; k < j; k++) {
					Character ch = s.charAt(k);
					if(hashSet.contains(ch)) {
						flag = false;
						break;
					}
					hashSet.add(ch);
				}
				if(flag) maxLength = Math.max(maxLength, j-i);
			}
		}
		
		return maxLength;
	}

	/**
	 * @description 滑动窗口
	 * @return
	 */
	public int lengthOfLongestSubstring_2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
	}
	
	/**
	 * @description 优化的滑动窗口
	 * @return
	 */
	public int lengthOfLongestSubstring_3(String s) {
		int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); 
        
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
	}
}
