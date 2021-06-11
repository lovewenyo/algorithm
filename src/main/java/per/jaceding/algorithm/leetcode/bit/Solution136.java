package per.jaceding.algorithm.leetcode.bit;

/**
 * @author jaceding
 * @date 2021/6/11
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int num = nums[0];
        for (int i = 1; i < n; i++) {
            num ^= nums[i];
        }
        return num;
    }

    public static void main(String[] args) {

    }
}
