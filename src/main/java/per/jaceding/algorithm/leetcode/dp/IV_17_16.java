package per.jaceding.algorithm.leetcode.dp;

/**
 * 确定状态变量：
 * dp[x] 数组长度为x的最大预约时间
 * <p>
 * 确定状态转移方程：
 * dp[x] = Math.max(dp[x-1], dp[x-2] + nums[x])
 * <p>
 * 确定边界条件：
 * dp[0] = nums[0];
 * dp[1] = Math.max(nums[0], nums[1])
 *
 * @author jaceding
 * @date 2021/5/25
 */
public class IV_17_16 {

    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int p = nums[0], q = Math.max(p, nums[1]), t;
        for (int i = 2; i < nums.length; i++) {
            t = q;
            q = Math.max(q, p + nums[i]);
            p = t;
        }
        return q;
    }
}
