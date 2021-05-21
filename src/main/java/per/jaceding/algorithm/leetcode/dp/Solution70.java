package per.jaceding.algorithm.leetcode.dp;

/**
 * 确定状态变量：
 * dp[x-1] 表示爬到x阶楼顶的方法种数
 * <p>
 * 确定状态转移方程：
 * dp[x] = dp[x-1] + dp[x-2]
 * <p>
 * 确定边界条件：
 * dp[0] = 1
 * dp[1] = 2
 * dp[2] = 3
 *
 * @author jaceding
 * @date 2021/5/21
 */
public class Solution70 {

    public int climbStairs(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    /**
     * 优化一下空间复杂度
     */
    public int climbStairs_opt(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int p = 1, q = 2;
        for (int i = 2; i < n; i++) {
            q = p + q;
            p = q - p;
        }
        return q;
    }
}
