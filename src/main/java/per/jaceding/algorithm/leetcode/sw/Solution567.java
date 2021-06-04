package per.jaceding.algorithm.leetcode.sw;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author jaceding
 * @date 2021/6/3
 */
public class Solution567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> needs = new HashMap<>(s1.length());
        LinkedList<Character> windows = new LinkedList<>();
        int valid = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            windows.add(c);
            if (needs.containsKey(c)) {
                needs.put(c, needs.get(c) - 1);
                if (needs.get(c) == 0) {
                    valid++;
                }
            }
        }
        if (valid == needs.size()) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            Character c = windows.removeFirst();
            if (needs.containsKey(c)) {
                needs.put(c, needs.get(c) + 1);
                if (needs.get(c) == 1) {
                    valid--;
                }
            }
            c = s2.charAt(i);
            windows.add(c);
            if (needs.containsKey(c)) {
                needs.put(c, needs.get(c) - 1);
                if (needs.get(c) == 0) {
                    valid++;
                    if (valid == needs.size()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(new Solution567().checkInclusion(s1, s2));
    }
}
