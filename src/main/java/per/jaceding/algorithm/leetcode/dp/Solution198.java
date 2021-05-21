package per.jaceding.algorithm.leetcode.dp;

/**
 * 确定状态变量：
 * dp[x-1] 表示房屋数组长度为x时能够窃取的最高金额
 * <p>
 * 确定状态转义方程：
 * dp[x] = Math.max(dp[x-1], dp[x-2] + arr[x])
 * <p>
 * 确定边界值：
 * dp[0] = nums[0];
 * dp[1] = Math.max(nums[0], nums[1])
 *
 * @author jaceding
 * @date 2021/5/21
 */
public class Solution198 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    /**
     * 优化一下空间复杂度
     */
    public int rob_1(int[] nums) {
        int n = nums.length;
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int p = nums[0], q = Math.max(p, nums[1]), t;
        for (int i = 2; i < n; i++) {
            t = q;
            q = Math.max(q, p + nums[i]);
            p = t;
        }
        return q;
    }

    /**
     * 再优化一下空间复杂度
     */
    public int rob_2(int[] nums) {
        int n = nums.length;
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }
        return nums[n - 1];
    }
}
