package per.jaceding.algorithm.leetcode.dp;

/**
 * 确定状态变量：
 * dp[x][y] 表示移动到（x, y）时的最小路径和
 * <p>
 * 确定状态转移方程：
 * 当 x > 0 , y > 0 时：dp[x][y] = math.min(dp[x-1][y], dp[x][y-1]) + arr[x][y]
 * 当 x == 0 时， dp[0][y] = dp[0][y-1] + arr[0][y]
 * 当 y == 0 时， dp[x][0] = dp[x-1][0] + arr[x][0]
 * <p>
 * 确定边界条件：
 * dp[0][0] = arr[x][y]
 *
 * @author jaceding
 * @date 2021/5/23
 */
public class Solution64 {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 优化一下空间复杂度
     */
    public int minPathSum_opt(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
