package per.jaceding.algorithm.leetcode.dp;

/**
 * leftMax[i]、rightMax[i]分别表示第i出 左边（含自身）最大值和右边（含自身）最大值
 * 则第i处能接的雨水 num = Math.min(leftMax[i], rightMax[i]) - height[i]
 *
 * @author jaceding
 * @date 2021/6/8
 */
public class Solution42 {

    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                leftMax[i] = height[i];
                rightMax[n - 1 - i] = height[n - 1 - i];
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
                rightMax[n - 1 - i] = Math.max(rightMax[n - i], height[n - 1 - i]);
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution42().trap(arr));
    }
}
