package per.jaceding.algorithm.leetcode.heap;

import java.util.*;

/**
 * @author jaceding
 * @date 2021/6/10
 */
public class Solution347 {

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        if (k < 0 || n == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else if (entry.getValue() > queue.peek().getValue()) {
                queue.poll();
                queue.add(entry);
            }
        }
        int[] arr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            arr[i] = queue.poll().getKey();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(new Solution347().topKFrequent(arr, k)));
    }
}
