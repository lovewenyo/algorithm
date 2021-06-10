package per.jaceding.algorithm.leetcode.heap;

import java.util.PriorityQueue;

/**
 * todo: 解决运行超时
 *
 * @author jaceding
 * @date 2021/6/10
 */
public class Solution719 {

    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int abs = Math.abs(nums[i] - nums[j]);
                if (queue.size() < k) {
                    queue.add(abs);
                } else if (abs < queue.peek()) {
                    queue.poll();
                    queue.add(abs);
                }
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[] arr = {62,100,4}; // 38 58 96
        int k = 2;
        System.out.println(new Solution719().smallestDistancePair(arr, k));
    }
}
