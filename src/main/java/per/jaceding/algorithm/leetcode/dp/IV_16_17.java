package per.jaceding.algorithm.leetcode.dp;

/**
 * 确定状态变量：
 * dp[x] 以第x个元素结尾的连续数列的最大和
 * <p>
 * 确定状态转移方程：
 * 如果 dp[x-1] < 0，则：dp[x] = nums[x];
 * 否则：dp[x] = dp[x-1] + nums[x];
 * 最终的结果是 dp 数组中最大的数
 * <p>
 * 确定边界条件：
 * dp[0] = nums[0]
 *
 * @author jaceding
 * @date 2021/5/25
 */
public class IV_16_17 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp = nums[0], max = dp;
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

    public static void main(String[] args) {

    }
}
