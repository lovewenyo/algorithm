package per.jaceding.algorithm.leetcode.dp;

/**
 * 确定状态变量：
 * dp[x][y] 表示移动到（x, y）时的路径总数
 * <p>
 * 确定状态转移方程：
 * dp[x][y] = dp[x-1][y] + dp[x][y-1]
 * <p>
 * 确定边界条件：
 * dp[0][0] = 0
 * dp[0][y] = 1
 * dp[x][0] = 1
 *
 * @author jaceding
 * @date 2021/5/22
 */
public class Solution62 {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 优化一下空间复杂度(这里应该还能优化一下，空间复杂度不应该是O(n), 而应该是 O(Math.min(m, n)) )
     */
    public int uniquePaths_opt(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] dp = new int[m];
        for (int i = 1; i < m; i++) {
            dp[i] = 1;
        }
        int q = 0;
        for (int i = 1; i < n; i++) {
            q = 1;
            for (int j = 1; j < m; j++) {
                q = q + dp[j];
                dp[j] = q;
            }
        }
        return q;
    }
}
