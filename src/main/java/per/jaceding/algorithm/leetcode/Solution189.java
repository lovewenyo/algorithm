package per.jaceding.algorithm.leetcode;

import java.util.Arrays;

/**
 * @author jaceding
 * @date 2020/9/28
 */
public class Solution189 {

    /**
     * 旋转数组
     *
     * @param nums 数组
     * @param k    向右移动 k 个位置
     */
    public synchronized void rotate(int[] nums, int k) {
        int len  = nums.length;
        k = k % len;
        int count = 0;         // 记录交换位置的次数，n个同学一共需要换n次
        for(int start = 0; count < len; start++) {
            int cur = start;       // 从0位置开始换位子
            int pre = nums[cur];
            do{
                int next = (cur + k) % len;
                int temp = nums[next];    // 来到角落...
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            }while(start != cur)  ;     // 循环暂停，回到起始位置，角落无人
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        new Solution189().rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
