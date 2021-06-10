package per.jaceding.algorithm.leetcode.heap;

import java.util.PriorityQueue;

/**
 * 最大堆 解决TOP K问题（非最优解）
 *
 * @author jaceding
 * @date 2021/6/10
 */
public class Jz_40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        int n = arr.length;
        if (k == 0 || n == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < n; i++) {
            if (heap.size() < k) {
                heap.add(arr[i]);
            } else if (arr[i] < heap.peek()) {
                heap.poll();
                heap.add(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[n - 1 - i] = heap.poll();
        }
        return res;
    }
}
