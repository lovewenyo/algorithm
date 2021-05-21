package per.jaceding.algorithm.leetcode.dp;

/**
 * 确定状态变量：
 * dp[x-1] 表示爬到x阶楼顶的方法种数
 * <p>
 * 确定状态转移方程：
 * dp[x] = dp[x-1] + dp[x-2] + dp[x-3]
 * <p>
 * 确定边界条件：
 * dp[0] = 1
 * dp[1] = 2
 * dp[2] = 4
 *
 * @author jaceding
 * @date 2021/5/21
 */
public class IV_08_01 {

    public int waysToStep(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        int a = 1, b = 2, c = 4, t1, t2;
        for (int i = 3; i < n; i++) {
            t1 = c;
            t2 = b;
            c = ((c + b) % 1000000007 + a) % 1000000007;
            b = t1;
            a = t2;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(new IV_08_01().waysToStep(61));
    }
}
