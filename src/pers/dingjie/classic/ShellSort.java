package pers.dingjie.classic;

/**
 * @description : 希尔排序
 * @author      : dingjie
 * @date 	    : 2017年9月4日 下午1:54:03 
 */
public class ShellSort {
	
	/**
	 * @description 希尔排序
	 */
	public void shellSort_1(int[] arr) {
		int n = arr.length;
		int incre,temp,j;
		
		for(incre = n/2; incre >= 1;incre = incre/2) //控制incre的大小
			for (int i = incre; i < n; ++i)		 //每组的直接插入排序
				if(arr[i] < arr[i-incre]) {
					temp = arr[i];
					for (j = i-incre;j >= 0 && arr[j] > temp; j = j - incre)
						arr[j+incre] = arr[j];
					arr[j+incre] = temp;
				}	
	}
	
	/**
	 * @description 希尔排序 (下标为0的数据为哨兵)
	 */
	public void shellSort_2(int[] arr) {
		int n = arr.length-1;
		int incre,temp,j;
		
		for(incre = n/2; incre >= 1;incre = incre/2) //控制incre的大小
			for (int i = incre+1; i <= n; ++i)		 //每组的直接插入排序
				if(arr[i] < arr[i-incre]) {
					temp = arr[i];
					for (j = i-incre;j >= 0 && arr[j] > temp; j = j - incre)
						arr[j+incre] = arr[j];
					arr[j+incre] = temp;
				}	
	}
	
	/**
	 * @description 希尔排序
	 */
	public void shellSort_3(int[] arr) {
		int n = arr.length;
		int incre = n / 2;
	    int j;
	    int temp;
	    
	    while (incre >= 1) {
	        for (int i = incre; i < n; i++) {
	            temp = arr[i];
	            j = i - incre;
	            while (j >= 0 && arr[j] > temp) {
	            	arr[j + incre] = arr[j];
	                j = j - incre;
	            }
	            arr[j + incre] = temp;
	        }
	        incre = incre / 2;
	    }
	}
}
