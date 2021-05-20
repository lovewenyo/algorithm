package per.jaceding.algorithm.leetcode.dp;

/**
 * 最小花费爬楼梯
 * <p>
 * 确定状态变量：
 * dp[x] 表示爬到第x阶楼梯时的最小花费
 * <p>
 * 确定状态转移方程：
 * dp[x] = Math.min(dp[x-1], dp[x-2]) + cost[x]
 * 设数组长度为n，最终结果就是：Math.min(dp[n-1], dp[n-2])
 * <p>
 * 确定边界条件：
 * dp[0] = cost[0];
 * dp[1] = cost[1];
 *
 * @author jaceding
 * @date 2021/5/20
 */
public class Solution746 {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    /**
     * 优化一下空间复杂度，不过不是最优解，可以直接复用cost数组存储元素
     */
    public int minCostClimbingStairs_opt(int[] cost) {
        int n = cost.length;
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int p = cost[0], q = cost[1], t;
        for (int i = 2; i < n; i++) {
            t = Math.min(p, q) + cost[i];
            p = q;
            q = t;
        }
        return Math.min(p, q);
    }
}
