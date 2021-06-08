package per.jaceding.algorithm.leetcode.stack;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 用队列实现栈
 *
 * @author jaceding
 * @date 2021/6/8
 */
public class Solution225 {

    Deque<Integer> queue1 = new ArrayDeque<>();
    Deque<Integer> queue2 = new ArrayDeque<>();

    boolean isQueue1 = true;

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (isQueue1) {
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            isQueue1 = false;
        } else {
            queue2.add(x);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
            isQueue1 = true;
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return isQueue1 ? queue2.poll() : queue1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return isQueue1 ? queue2.peek() : queue1.poll();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return isQueue1 ? queue2.isEmpty() : queue1.isEmpty();
    }
}
