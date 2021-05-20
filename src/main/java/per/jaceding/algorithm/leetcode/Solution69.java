package per.jaceding.algorithm.leetcode;

/**
 * No.69 https://leetcode-cn.com/problems/sqrtx/
 *
 * @author jaceding
 * @date 2020/9/28
 */
public class Solution69 {

    public static int mySqrt(int x) {
        int low = 0;
        int high = x;
        int m = (low + high) / 2;
        for (; ; ) {
            if (1L * m * m <= x) {
                if ((m + 1) * (m + 1) > x) {
                    return m;
                }
                low = m + 1;
            } else {
                if (1L * (m - 1) * (m - 1) <= x) {
                    return m - 1;
                }
                high = m - 1;
            }
            m = (low + high) / 2;
        }
    }
}
