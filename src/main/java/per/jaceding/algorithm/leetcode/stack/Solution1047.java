package per.jaceding.algorithm.leetcode.stack;

import java.util.LinkedList;

/**
 * @author jaceding
 * @date 2021/6/9
 */
public class Solution1047 {

    public String removeDuplicates(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            buf.append(stack.get(stack.size() - 1 - i));
        }

        return buf.toString();
    }

    public static void main(String[] args) {
        String str = "abbaca";
        System.out.println(new Solution1047().removeDuplicates(str));
    }
}
