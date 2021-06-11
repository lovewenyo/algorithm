package per.jaceding.algorithm.leetcode.greedy;

import java.util.Arrays;

/**
 * @author jaceding
 * @date 2021/6/11
 */
public class Solution455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int sum = 0;
        int j = 0;
        for (int i = 0; i < s.length && j < g.length; i++) {
            if (s[i] >= g[j]) {
                j++;
                sum++;
            }
        }
        return sum;
    }
}
