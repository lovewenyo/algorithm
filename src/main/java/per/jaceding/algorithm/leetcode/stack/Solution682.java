package per.jaceding.algorithm.leetcode.stack;

import java.util.LinkedList;

/**
 * @author jaceding
 * @date 2021/6/8
 */
public class Solution682 {

    public int calPoints(String[] ops) {
        int n = ops.length;
        if (n == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        for (String op : ops) {
            switch (op) {
                case "+":
                    Integer p = stack.pop();
                    Integer q = stack.pop();
                    stack.push(q);
                    stack.push(p);
                    stack.push(q + p);
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
