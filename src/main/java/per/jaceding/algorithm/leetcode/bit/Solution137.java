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
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return (int) map.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).toArray()[0];
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 0, 1, 99};
        System.out.println(new Solution137().singleNumber(arr));
    }
}
