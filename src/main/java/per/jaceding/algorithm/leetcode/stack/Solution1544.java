package per.jaceding.algorithm.leetcode.stack;

import java.util.LinkedList;

/**
 * @author jaceding
 * @date 2021/6/9
 */
public class Solution1544 {

    public String makeGood(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && Math.abs(ch - stack.peek()) == 32) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuffer buf = new StringBuffer();
        for (int i = stack.size() - 1; i >= 0; i--) {
            buf.append(stack.get(i));
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(new Solution1544().makeGood(s));
    }
}
