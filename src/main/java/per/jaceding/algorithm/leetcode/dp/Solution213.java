package per.jaceding.algorithm.leetcode.dp;

/**
 * 确定状态变量：
 * dp[x-1][0] 表示房屋数组长度为x时，且第一家不偷能够窃取的最高金额
 * dp[x-1][1] 表示房屋数组长度为x时，且第一家偷能够窃取的最高金额
 * 确定状态转移方程：
 * dp[x][0] = Math.max(dp[x-1][0], dp[x-2][0] + nums[x])
 * dp[x][1] = Math.max(dp[x-1][1], dp[x-2][1] + nums[x])，如果 x = n - 1, 那么 dp[x][1] = Math.max(dp[x-1][1], dp[x-2][1])
 * 确定边界值：
 * dp[0][0] = 0;
 * dp[0][1] = nums[0];
 * dp[1][0] = nums[1];
 * dp[1][1] = nums[0];
 *
 * @author jaceding
 * @date 2021/5/21
 */
public class Solution213 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = nums[0];

        for (int i = 2; i < n; i++) {
            if (i == n - 1) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    /**
     * 优化一下空间复杂度
     */
    public int rob_opt(int[] nums) {
        int n = nums.length;
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int p0, p1, q0, q1, t0, t1;
        p0 = 0;
        p1 = nums[0];
        q0 = nums[1];
        q1 = nums[0];

        for (int i = 2; i < n; i++) {
            t1 = q1;
            if (i == n - 1) {
                q1 = Math.max(q1, p1);
            } else {
                q1 = Math.max(q1, p1 + nums[i]);
            }
            t0 = q0;
            q0 = Math.max(q0, p0 + nums[i]);
            p0 = t0;
            p1 = t1;
        }
        return Math.max(q0, q1);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1};
        System.out.println(new Solution213().rob_opt(arr));
    }
}
