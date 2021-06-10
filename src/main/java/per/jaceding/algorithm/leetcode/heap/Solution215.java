package per.jaceding.algorithm.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小堆 解决TOP K问题
 *
 * @author jaceding
 * @date 2021/6/10
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>(n, Comparator.comparingInt(o -> o));
        for (int i = 0; i < n; i++) {
            if (heap.size() < k) {
                heap.add(nums[i]);
            } else if (nums[i] > heap.peek()) {
                heap.poll();
                heap.add(nums[i]);
            }
        }
        return heap.peek();
    }
}
