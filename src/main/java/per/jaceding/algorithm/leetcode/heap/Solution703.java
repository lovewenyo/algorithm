package per.jaceding.algorithm.leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小堆 解决TOP K问题
 *
 * @author jaceding
 * @date 2021/6/10
 */
public class Solution703 {

    int k;

    PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o));

    public Solution703(int k, int[] nums) {
        this.k = k;
        if (nums.length > 0) {
            Arrays.stream(nums).boxed().forEach(e -> {
                if (heap.size() < k) {
                    heap.add(e);
                } else if (heap.peek() < e) {
                    heap.poll();
                    heap.add(e);
                }
            });
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.add(val);
        } else if (heap.peek() < val) {
            heap.poll();
            heap.add(val);
        }
        if (heap.size() < k) {
            return -1;
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        int k = 1;
        int[] arr = {};
        Solution703 solution703 = new Solution703(k, arr);
        System.out.println(solution703.add(-3));
        System.out.println(solution703.add(-2));
        System.out.println(solution703.add(-4));
        System.out.println(solution703.add(0));
        System.out.println(solution703.add(4));

    }
}