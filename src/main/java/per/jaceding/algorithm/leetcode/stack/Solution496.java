package per.jaceding.algorithm.leetcode.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author jaceding
 * @date 2021/6/8
 */
public class Solution496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Map<Integer, Integer> map = new HashMap<>(n, 0.75f);
        for (int i = 0; i < m; i++) {
            boolean flag = true;
            for (int j = i + 1; j < m; j++) {
                if (nums2[j] > nums2[i]) {
                    map.put(nums2[i], nums2[j]);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                map.put(nums2[i], -1);
            }
        }
        for (int i = 0; i < n; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }

    /**
     * 单调栈
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Map<Integer, Integer> map = new HashMap<>(n, 0.75f);
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                map.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] num1 = {2, 4};
        int[] num2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new Solution496().nextGreaterElement1(num1, num2)));
    }
}
