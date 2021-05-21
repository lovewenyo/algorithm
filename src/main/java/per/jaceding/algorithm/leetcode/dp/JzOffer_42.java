package per.jaceding.algorithm.leetcode.dp;

/**
 * 确定状态变量：
 * dp[x-1] 代表以元素x为结尾的连续子数组最大和
 * <p>
 * 确定状态转移方程：
 * 如果 dp[x-1] < 0，则：dp[x] = nums[x];
 * 否则：dp[x] = dp[x-1] + nums[x];
 * <p>
 * 确定边界条件：
 * dp[0] = nums[0]
 *
 * @author jaceding
 * @date 2021/5/21
 */
public class JzOffer_42 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArray_opt(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp < 0) {
                dp = nums[i];
            } else {
                dp = dp + nums[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new JzOffer_42().maxSubArray(arr));
    }

}
