package per.jaceding.algorithm.leetcode.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jaceding
 * @date 2021/6/11
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int m = (int) (Math.pow(2, n) - 1);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= m; i++) {
            List<Integer> integerList = new ArrayList<>();
            String s = Integer.toBinaryString(i);
            int abs = n - s.length();
            for (int j = abs; j < n; j++) {
                if (s.charAt(j - abs) == '1') {
                    integerList.add(nums[j]);
                }
            }
            list.add(integerList);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new Solution78().subsets(arr).toString());
    }
}
