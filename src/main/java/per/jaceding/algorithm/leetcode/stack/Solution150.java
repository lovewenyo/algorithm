package per.jaceding.algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jaceding
 * @date 2021/6/8
 */
public class Solution150 {

    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        if (n == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Deque<Integer> stack = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            String str = tokens[i];
            switch (str) {
                case "+":
                case "*":
                case "-":
                case "/":
                case "%":
                    stack.push(operation(str, stack));
                    break;
                default:
                    stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }

    private int operation(String op, Deque<Integer> stack) {
        int q = stack.pop();
        int p = stack.pop();
        switch (op) {
            case "+":
                return p + q;
            case "*":
                return p * q;
            case "-":
                return p - q;
            case "/":
                return p / q;
            case "%":
                return p % q;
            default:
                return 0;
        }
    }
}
