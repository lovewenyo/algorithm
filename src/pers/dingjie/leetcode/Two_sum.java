package pers.dingjie.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description : 两数之和
 * 		给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 	          你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * @author      : dingjie
 * @date 	    : 2018年9月1日 下午10:30:54 
 */
public class Two_sum {

	/**
	 * @description 暴力法
	 * 时间复杂度：O(n^2) 	空间复杂度：O(1)
	 */
	public static int[] twoSum(int[] nums, int target) {
    	for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(target == nums[j] + nums[i]) {
					return new int[] { i, j };
				}
			}
		}
		return null;  
    }
	
	/**
	 * @description 两遍哈希表：以空间换取速度
	 *  时间复杂度：O(n)  空间复杂度：O(n)
	 */
	public static int[] twoSum2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
		return null;  
    }
	
	/**
	 * @description 一遍哈希表
	 *  时间复杂度：O(n)  空间复杂度：O(n)
	 */
	public static int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
		return null;  
    }

	public static void main(String[] args) {
		int[] num = {2, 7, 11, 15};
		int target = 9;

		int[] arr = twoSum(num,target);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
