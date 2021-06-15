package per.jaceding.algorithm.leetcode.bit;

/**
 * 非最优解
 *
 * @author jaceding
 * @date 2021/6/15
 */
public class Solution338 {

    public int[] countBits(int n) {
        if (n < 0) {
            return new int[]{};
        }
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = Integer.bitCount(i);
        }
        return arr;
    }
}
