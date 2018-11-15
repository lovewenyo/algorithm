package pers.dingjie.classic;

/**
问题描述:
	给一组大小为n的整数数组，计算长度为k的子数组（元素为连续的）的最大值
	
Input  : arr[] = {100, 200, 300, 400}
         k = 2
Output : 700

Input  : arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}
         k = 4 
Output : 39			
 */

/**
 * @description : 滑动窗口
 * @author      : dingjie
 * @date 	    : 2018年11月15日 上午11:20:07 
 */
public class SlidingWindow {
	
	/**
	 * @description 暴力法
	 * @return
	 */
	public int maxSum_1(int arr[], int n, int k){ 
        int max_sum = Integer.MIN_VALUE ; 
      
        for (int i = 0; i < n - k + 1; i++){ 
            int current_sum = 0; 
            for (int j = 0; j < k; j++) 
                current_sum = current_sum + arr[i + j]; 
      
            max_sum = Math.max(current_sum , max_sum ); 
        } 
      
        return max_sum; 
    } 
	
	/**
	 * @description 滑动窗口法	 
	 * @return
	 */
	public int maxSum_2(int arr[], int n, int k){ 
        if (n < k){ 
	        System.out.println("Invalid"); 
	        return -1; 
        } 
        
        int max_sum = 0; 
        for (int i = 0; i < k; i++) 
        	max_sum += arr[i]; 
      
        int window_sum = max_sum; 
        for (int i = k; i < n; i++){ 
	        window_sum += arr[i] - arr[i - k]; 
	        max_sum = Math.max(max_sum, window_sum); 
        } 
      
        return max_sum; 
    } 
}
