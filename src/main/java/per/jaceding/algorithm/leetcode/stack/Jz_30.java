package per.jaceding.algorithm.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jaceding
 * @date 2021/6/9
 */
public class Jz_30 {

    private final Deque<Integer> stack1 = new ArrayDeque<>();

    private final Deque<Integer> stack2 = new ArrayDeque<>();

    public int min() {
        return stack2.peek();
    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty()) {
            stack2.push(val);
        } else {
            stack2.push(Math.min(val, stack2.peek()));
        }
    }

    public void pop() {
        if (stack1.isEmpty()) {
            return;
        }
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }
}
