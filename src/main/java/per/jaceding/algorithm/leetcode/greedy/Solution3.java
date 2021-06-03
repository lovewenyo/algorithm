package per.jaceding.algorithm.leetcode.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在前后指针l, r, max表示无重复的最长字串，windows表示当前窗口包含的元素
 * 第一步，移动指针r一直向后移动，每移动一次，将 s[r] 元素添加入 windows 中，直到windows中已存在该元素，此时可能最大的无重复字符的字串
 * 第二步，移动指针l一直向后移动，每移动一次，则将s[l]元素从 windows 移除，直到移除的元素s[l] 与 s[r] 相等
 * 第三步，重复上述操作，直到 r == s.length
 *
 * @author jaceding
 * @date 2021/5/28
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Set<Character> windows = new HashSet<>(s.length());
        int l = 0, r = 0, max = Integer.MIN_VALUE;
        char e;
        while (r < s.length()) {
            e = s.charAt(r);
            if (windows.contains(e)) {
                max = Math.max(max, r - l);
                do {
                    e = s.charAt(l);
                    windows.remove(e);
                    l++;
                } while (e != s.charAt(r));
            } else {
                windows.add(e);
                r++;
                if (r == s.length()) {
                    max = Math.max(max, r - l);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("au"));
    }
}
