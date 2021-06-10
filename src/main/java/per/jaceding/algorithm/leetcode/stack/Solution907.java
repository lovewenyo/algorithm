package per.jaceding.algorithm.leetcode.stack;

import java.util.LinkedList;

/**
 * todo: 已完成的代码都运行超时
 *
 * @author jaceding
 * @date 2021/6/9
 */
public class Solution907 {

    /**
     * 暴力法（运行超时）
     */
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = (int) ((sum + getMin(arr, i, j)) % (Math.pow(10, 9) + 7));
            }
        }
        return sum;
    }

    public int getMin(int[] arr, int left, int right) {
        int min = arr[right];
        for (int i = left; i < right; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    /**
     * 最小栈优化一下（运行超时）
     */
    public int sumSubarrayMins1(int[] arr) {
        int n = arr.length;
        int[][] minArr = new int[n][n];
        MinStack minStack = new MinStack();
        for (int i = 0; i < n; i++) {
            minStack.clear();
            for (int j = i; j < n; j++) {
                minStack.push(arr[j]);
                minArr[i][j] = minStack.getMin();
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = (sum + minArr[i][j]) % 1000000007;
            }
        }
        return sum;
    }

    static class MinStack {
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

        public void clear() {
            stack1.clear();
            stack2.clear();
        }
    }

    /**
     * 动态规划：min(dp[i][j+1]) = min(dp[i][j], arr[j+1])
     * dp[0][0] = arr[0]
     * dp[1][1] = arr[1]
     */
    public int sumSubarrayMins2(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
            sum = (sum + dp[i][i]) % 1000000007;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], arr[j]);
                sum = (sum + dp[i][j]) % 1000000007;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {11, 81, 94, 43, 3};
        System.out.println(new Solution907().sumSubarrayMins1(arr));
    }
}
