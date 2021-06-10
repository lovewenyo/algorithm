package per.jaceding.algorithm.leetcode.heap;

import java.util.*;

/**
 * 最大堆 解决TOP K问题（非最优解）
 *
 * @author jaceding
 * @date 2021/6/10
 */
public class Solution373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (k == 0 || n1 == 0 || n2 == 0) {
            return Collections.EMPTY_LIST;
        }
        Comparator<Integer> comparator = (o1, o2) -> o2 - o1;

        PriorityQueue<Integer> queue1 = new PriorityQueue<>(k, comparator);
        setQueue(queue1, nums1, k);

        PriorityQueue<Integer> queue2 = new PriorityQueue<>(k, comparator);
        setQueue(queue2, nums2, k);

        Comparator<List<Integer>> entyComparator = (o1, o2) -> o2.stream().reduce(0, Integer::sum) - o1.stream().reduce(0, Integer::sum);
        PriorityQueue<List<Integer>> queue3 = new PriorityQueue<>(k, entyComparator);

        for (int i = 0; i < k && i < n1; i++) {
            for (int j = 0; j < k && j < n2; j++) {
                List<Integer> list = Arrays.asList(nums1[i], nums2[j]);
                if (queue3.size() < k) {
                    queue3.add(list);
                } else if (entyComparator.compare(list, queue3.peek()) > 0) {
                    queue3.poll();
                    queue3.add(list);
                }
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        while (!queue3.isEmpty()) {
            result.add(queue3.poll());
        }
        Collections.reverse(result);
        return result;
    }

    private void setQueue(PriorityQueue<Integer> queue, int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (queue.size() < k) {
                queue.add(nums[i]);
            } else if (nums[i] < queue.peek()) {
                queue.poll();
                queue.add(nums[i]);
            }
        }
        for (int i = 0; i < k && i < n; i++) {
            nums[i] = queue.poll();
        }
    }
}
