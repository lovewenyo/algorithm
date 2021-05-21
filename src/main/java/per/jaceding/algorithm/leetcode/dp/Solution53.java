package per.jaceding.algorithm.leetcode.dp;

/**
 * 确定状态变量：
 * dp[x-1] 代表以元素x为结尾的连续子数组最大和
 * <p>
 * 确定状态转移方程：
 * 如果 dp[x-1] < 0，则：dp[x] = nums[x];
 * 否则， dp[x] = dp[x-1] + nums[x]
 * <p>
 * 确定边界条件：
 * dp[0] = nums[0];
 *
 * @author jaceding
 * @date 2021/5/21
 */
public class Solution53 {

    /**
     * 可以通过复用原数据优化一下空间复杂度
     */
    public int maxSubArray(int[] nums) {
        int dp = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp < 0) {
                dp = nums[i];
            } else {
                dp += nums[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }
}
