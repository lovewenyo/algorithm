package per.jaceding.algorithm.leetcode.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jaceding
 * @date 2021/6/11
 */
public class Solution137 {

    /**
     * 哈希表
     */
    public int singleNumber(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>(n, 0.75f);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return (int) map.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).toArray()[0];
    }

    /**
     * 数位统计
     */
    public int singleNumber1(int[] nums){
        int[] cnt = new int[32];
        for (int x : nums) {
            for (int i = 0; i < 32; i++) {
                if (((x >> i) & 1) == 1) {
                    cnt[i]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((cnt[i] % 3 & 1) == 1) {
                ans += (1 << i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(new Solution137().singleNumber(arr));
    }
}
