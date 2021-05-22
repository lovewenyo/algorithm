package per.jaceding.algorithm.leetcode.dp;

/**
 * 确定状态变量：
 * dp[x][y] 表示移动到（x, y）时的路径总数
 * <p>
 * 确定状态转移方程：
 * 如果：arr[x][y] = 1, 则dp[x][y] = 0
 * 否则：dp[x][y] = dp[x-1][y] + dp[x][y-1]
 * <p>
 * 确定边界条件：
 * dp[0][0] = 0
 * 如果：arr[0][y] = 1, 则dp[0][y] = 0， 否则：dp[0][y] = 1
 * 如果：arr[x][0] = 1, 则dp[x][0] = 0， 否则：dp[x][0] = 1
 *
 * @author jaceding
 * @date 2021/5/22
 */
public class Solution63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            obstacleGrid[0][0] = 0;
        } else {
            obstacleGrid[0][0] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = obstacleGrid[i - 1][0];
            }
        }
        for (int i = 1; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
            }

        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
