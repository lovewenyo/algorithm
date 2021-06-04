package per.jaceding.algorithm.leetcode.greedy;

/**
 * @author jaceding
 * @date 2021/6/4
 */
public class Solution45 {

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0};
        System.out.println(new Solution45().jump(arr));
    }
}
