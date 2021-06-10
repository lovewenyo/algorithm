package per.jaceding.algorithm.leetcode.heap;

import java.util.PriorityQueue;

/**
 * @author jaceding
 * @date 2021/6/10
 */
public class Solution378 {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if (k == 1) {
            return matrix[0][0];
        }
        if (k == n * n) {
            return matrix[n - 1][n - 1];
        }
        int i = 0, j = 0;
        int maxI = n - 1, maxJ = n - 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        while (i <= maxI && j <= maxJ) {
            if (queue.size() < k) {
                queue.add(matrix[i][j]);
            } else if (matrix[i][j] < queue.peek()) {
                queue.poll();
                queue.add(matrix[i][j]);
            } else {
                maxJ = j;
            }
            if (++j > maxJ) {
                j = 0;
                i++;
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[][] arr = {
                {-5}
        };
        int k = 1;
        System.out.println(new Solution378().kthSmallest(arr, k));
    }
}
