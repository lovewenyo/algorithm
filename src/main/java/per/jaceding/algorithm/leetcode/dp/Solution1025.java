package per.jaceding.algorithm.leetcode.dp;

/**
 * N=1, 爱丽丝无法选择，False
 * N=2, 爱丽丝选择1，鲍勃无法选择，True
 * N=3, 爱丽丝只能选择1，参考N=2，爱丽丝最终将会无法选择，False
 * N=4, 爱丽丝可以选择1或者2，如果爱丽丝选择1，参考N=3，鲍勃最终将会无法选择，True
 * N=5, 爱丽丝只能选择1，参考N=4，爱丽丝最终将会无法选择，False
 * N=6, 爱丽丝可以选择1、2、3，如果爱丽丝选1，参考N=5，鲍勃最终将会无法选择，True
 * N=7, 爱丽丝只能选择1，参考N=6，爱丽丝最终将会无法选择，False
 * N=8, 爱丽丝可以选择1、2、4，如果爱丽丝选1，参考N=7，鲍勃最终将会无法选择，True
 * N=9, 爱丽丝可以选择1、3，如果爱丽丝选1，参考N=8，爱丽丝最终将会无法选择，False，如果爱丽丝选择3，参考N=6，爱丽丝最终将会无法选择，False
 * <p>
 * 确定状态变量：
 * dp[x]=1 表示n为x+1时，先手会赢
 * dp[x]=0 表示n为x+1时，先手会输
 * <p>
 * 确定状态转移方程：
 * 对于任意能够整数n(n=x+1)的元素a, 如果 dp[x-a] = 0, 则dp[x] = 1，否则 dp[x]=0
 * <p>
 * dp[0] = 0
 * dp[1] = 1
 *
 * @author jaceding
 * @date 2021/5/25
 */
public class Solution1025 {

    public boolean divisorGame(int n) {
        if (n <= 1) {
            return false;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i + 1; j++) {
                if ((i + 1) % j == 0 && dp[i - j] == 0) {
                    dp[i] = 1;
                }
            }
        }
        return dp[n - 1] == 1;
    }

    /**
     * 优化：
     * 当N为偶数时，除数a可为奇数也可为偶数，N-a也可为奇数也可为偶数
     * 当N为奇数时，除数a只能为奇数，N-a只能为偶数
     * <p>
     * 当N为偶数时，爱丽丝可以选择奇数，这样鲍勃永远只能选择在N为奇数的时候做选择，鲍勃必输，爱丽丝必赢
     * 当N为奇数时，爱丽丝只能选择奇数，这样鲍勃可以一定能在N为偶数的时候选择，只要鲍勃一直选择奇数，鲍勃必赢，爱丽丝必输
     */
    public boolean divisorGame_opt(int n) {
        return n % 2 == 0;
    }
}
