package per.jaceding.algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最小栈的最佳解法: https://zhuanlan.zhihu.com/p/87257507
 *
 * @author jaceding
 * @date 2021/6/8
 */
public class Solution155 {

    private final Deque<Integer> stack = new ArrayDeque<>();

    private int min;

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
            stack.push(0);
        } else {
            int n = val - min;
            stack.push(n);
            if (n < 0) {
                min = n;
            }
        }
    }

    public void pop() {
        int n = stack.peek();
        if (n < 0) {
            min = min - n;
        }
        stack.pop();
    }

    public int top() {
        int n = stack.peek();
        if (n < 0) {
            return min;
        }
        return n + min;
    }

    public int getMin() {
        return min;
    }
}
