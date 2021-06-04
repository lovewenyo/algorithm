package per.jaceding.algorithm.leetcode.greedy;

/**
 * @author jaceding
 * @date 2021/6/4
 */
public class Solution55 {

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int index = 0;
        for (int i = index; i < nums.length; i = index) {
            int num = nums[i];
            int max = 0;
            for (int j = i; j <= i + num && j < nums.length; j++) {
                if (j + nums[j] >= nums.length - 1) {
                    return true;
                }
                if (nums[j] >= max) {
                    max = nums[j];
                    index = j;
                }
            }
            if (max == 0) {
                return false;
            }
            if (index == i) {
                index = i + nums[i];
            }
        }
        return true;
    }

    /**
     * 优化：max表示最大能到达的位置
     */
    public boolean canJump1(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int max = nums[0];
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new Solution55().canJump1(arr));
    }
}
