package per.jaceding.algorithm.leetcode.stack;

import java.util.LinkedList;

/**
 * @author jaceding
 * @date 2021/6/9
 */
public class IV_03_02 {

    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<Integer> stack2 = new LinkedList<>();

    public void push(int x) {
        if (stack1.isEmpty() || stack2.peek() > x) {
            stack2.push(x);
        } else {
            stack2.push(stack2.peek());
        }
        stack1.push(x);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
