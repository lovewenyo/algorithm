package per.jaceding.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jaceding
 * @date 2021/5/27
 */
public class IV_17_18 {

    public int[] shortestSeq(int[] big, int[] small) {
        if (big.length < small.length) {
            return new int[]{};
        }
        int l = 0, r = 0, e;
        int valid = 0;
        int flag = 0, min = Integer.MAX_VALUE;
        Map<Integer, Integer> need = new HashMap<>(small.length, 1f);
        Map<Integer, Integer> window = new HashMap<>(small.length, 1f);
        for (int i = 0; i < small.length; i++) {
            need.put(small[i], need.getOrDefault(small[i], 0) + 1);
        }
        while (r < big.length) {
            e = big[r];
            r++;
            if (need.containsKey(e)) {
                window.put(e, window.getOrDefault(e, 0) + 1);
                if (window.get(e).equals(need.get(e))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (r - l < min) {
                    flag = l;
                    min = r - l;
                }
                e = big[l];
                l++;
                if (need.containsKey(e)) {
                    if (window.get(e).equals(need.get(e))) {
                        valid--;
                    }
                    window.put(e, window.getOrDefault(e, 0) - 1);
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return new int[]{};
        }
        return new int[]{flag, flag + min - 1};
    }

    public static void main(String[] args) {
        int[] big = new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7};
        int[] small = new int[]{1, 5, 9};
        System.out.println(Arrays.toString(new IV_17_18().shortestSeq(big, small)));
    }
}
