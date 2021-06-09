package per.jaceding.algorithm.leetcode.stack;

import java.util.LinkedList;

/**
 * 可用双指针优化空间复杂度
 *
 * @author jaceding
 * @date 2021/6/9
 */
public class Solution844 {

    public boolean backspaceCompare(String s, String t) {
        LinkedList<Character> stack1 = new LinkedList<>();
        LinkedList<Character> stack2 = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if ('#' == s.charAt(i)) {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.push(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if ('#' == t.charAt(i)) {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            } else {
                stack2.push(t.charAt(i));
            }
        }
        return stack1.equals(stack2);
    }
}