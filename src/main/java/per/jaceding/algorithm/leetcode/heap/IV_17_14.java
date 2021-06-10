package per.jaceding.algorithm.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jaceding
 * @date 2021/6/10
 */
public class IV_17_14 {

    public int[] smallestK(int[] arr, int k) {
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
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        System.out.println(Arrays.toString(new IV_17_14().smallestK(arr, k)));
    }
}
