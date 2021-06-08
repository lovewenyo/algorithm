package per.jaceding.algorithm.leetcode.stack;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jaceding
 * @date 2021/6/8
 */
public class Solution225 {

    Deque<Integer> queue = new ArrayDeque<>();

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.push(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.pop();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
