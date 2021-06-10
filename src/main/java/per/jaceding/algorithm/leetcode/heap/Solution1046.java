package per.jaceding.algorithm.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @author jaceding
 * @date 2021/6/10
 */
public class Solution1046 {


    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if (n == 0) {
            return 0;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(n, (o1, o2) -> o2 - o1);
        for (int stone : stones) {
            heap.add(stone);
        }
        while (!heap.isEmpty()) {
            int p = heap.poll();
            if (heap.isEmpty()) {
                return p;
            }
            int q = heap.poll();
            if (p > q) {
                heap.add(p - q);
            }
        }
        return 0;
    }
}
