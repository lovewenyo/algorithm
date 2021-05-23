package per.jaceding.algorithm.leetcode.dp;

/**
 * 确定状态变量：
 * dp[x-1] 表示字符串长度为x时解码的总数
 * <p>
 * 确定状态转移方程：
 * 如果 s[x] 为 '0',
 * 且 s[x-1] 不为 1 或 2，则无法解码，直接返回0
 * 且 s[x-1] 为 1 或 2，则dp[x] = dp[x-2]
 * 如果 s[x-1] s[x] 可以构建为 [1, 26] 中的一个数，则：dp[x] = dp[x-1] + dp[x-2]
 * 如果 s[x-1] s[x] 不能构建为 [1, 26] 中的一个数，则：dp[x] = dp[x-1]
 * <p>
 * 确定边界条件：
 * dp[0] = 1
 *
 * @author jaceding
 * @date 2021/5/23
 */
public class Solution91 {

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int p, q, t;
        if (s.charAt(0) == '0') {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        } else {
            p = 1;
        }

        if (s.charAt(1) == '0') {
            if (s.charAt(0) != '1' && s.charAt(0) != '2') {
                return 0;
            }
            q = 1;
        } else if (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) != '7' && s.charAt(1) != '8' && s.charAt(1) != '9')) {
            q = 2;
        } else {
            q = 1;
        }

        for (int i = 2; i < s.length(); i++) {
            t = q;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                }
                q = p;
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) != '7' && s.charAt(i) != '8' && s.charAt(i) != '9')) {
                q += p;
            }
            p = t;
        }
        return q;
    }

    /**
     * 优化一下，求第二个初始值dp[1]的过程也通过状态转义方程计算
     */
    public int numDecodings_opt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int q;
        if (s.charAt(0) == '0') {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        } else {
            q = 1;
        }
        int p = 1, t;

        for (int i = 1; i < s.length(); i++) {
            t = q;
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                }
                q = p;
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) != '7' && s.charAt(i) != '8' && s.charAt(i) != '9')) {
                q += p;
            }
            p = t;
        }
        return q;
    }
}
