package pers.dingjie.classic;

/**
 * @description : 冒泡排序
 * @author      : dingjie
 * @date 	    : 2016年7月24日 上午10:21:37
 */
public class BubbleSort {	
    /**
     * @description 传统的冒泡排序
     */
    public void bubbleSort_1(int []arr) {
	    int n = arr.length;
	    
	    for(int i = 0 ; i< n-1; ++i) {//控制循环趟数
	        for(int j = 0; j < n-i-1; ++j) {//控制每一趟比较多少次
	            if(arr[j] > arr[j+1]){
	                int temp = arr[j] ;
	                arr[j] = arr[j+1] ;
	                arr[j+1] = temp;
	            }
	        }
	    }
    }
    
    /**
     * @description 改进后的冒泡排序
     *	设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。
     *	如果进行某一趟排序时并没有进行数据交换，则说明数据已经按要求排列好，可立即结束排序，减少比较次数
     */
    public void bubbleSort_2(int []arr){
        int i= arr.length - 1;  //初始时,最后位置保持不变
        
        while (i > 0) {
            int pos= 0;     //每趟开始时,无记录交换
            for (int j= 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    pos= j; //记录交换的位置
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            i = pos;        //为下一趟排序作准备
        }
    }

    /**
     * @description 改进后的冒泡排序
     * 	传统冒泡排序中每一趟排序操作只能找到一个最大值或最小值
     * 	我们考虑利用在每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) 
     * 	从而使排序趟数几乎减少了一半。
     */
    public void bubbleSort_3(int []arr){
        int low = 0;
        int high= arr.length - 1; //设置变量的初始值
        int temp,j;
     
        while (low < high) {
        	for (j= low; j < high; ++j) {  //正向冒泡,找到最大者
            	if (arr[j]> arr[j+1]) {
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            --high;                     //修改high值, 前移一位
            for ( j=high; j > low; --j) {  //反向冒泡,找到最小者
            	if (arr[j]<arr[j-1]) {
                    temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp; 
                }
            }
            ++low;                      //修改low值,后移一位
        }
    }

    /**
     * @description 鸡尾酒排序
     * 	上面两种排序的结合版	
     */
    public void bubbleSort_4(int []arr){
    	int high = arr.length - 1;
    	int temp,j,low = 0;
    	boolean swapped = true;
    	
    	while(swapped) {
    		swapped = false;
    		for (j= low; j < high; ++j) { 
    			if (arr[j]> arr[j+1]) {
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapped = true;
                }
			}
    		--high;
    		for ( j=high; j > low; --j) { 
    			if (arr[j]<arr[j-1]) {
                    temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp; 
                    swapped = true;
                }
    		}
    		++low; 
    	}
    }
}
