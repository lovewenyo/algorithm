package per.jaceding.algorithm.leetcode.dp;

import java.util.List;

/**
 * 确定状态变量：
 * dp[x][y] 代表到达第x层，第y个元素的最小路径和
 * <p>
 * 确定状态转移方程：
 * 当 x > y 时，dp[x][y] = Math.min(dp[x-1][y], dp[x-1][y-1]) + arr[x][y]
 * 当 x == y 时，dp[x][y] = dp[x-1][y-1] + arr[x][y]
 * 当 y == 0 时，dp[x][0] = dp[x-1][0] + arr[x][y]
 * 最终就是求dp[x]这一个数组中的最大值
 * <p>
 * 确定边界条件：
 * dp[0][0] = triangle[0][0];
 * dp[1][0] = dp[0]+ triangle[1][0]
 * dp[1][1] = dp[0]+ triangle[1][1]
 *
 * @author jaceding
 * @date 2021/5/24
 */
public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.isEmpty()) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(0, triangle.get(i - 1).get(0) + triangle.get(i).get(j));
                } else if (i == j) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                } else {
                    triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)) + triangle.get(i).get(j));
                }
            }
        }
        int min = triangle.get(triangle.size() - 1).get(0);
        for (int i = 1; i < triangle.get(triangle.size() - 1).size(); i++) {
            min = Math.min(min, triangle.get(triangle.size() - 1).get(i));
        }
        return min;
    }
}
