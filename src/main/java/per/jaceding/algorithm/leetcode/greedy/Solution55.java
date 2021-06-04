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

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        System.out.println(new Solution55().canJump(arr));
    }
}
