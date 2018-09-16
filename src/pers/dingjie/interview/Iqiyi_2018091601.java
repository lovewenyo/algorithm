package pers.dingjie.interview;

import java.util.Scanner;

/**
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 131072KB；其他语言 655360KB
题目描述：
	小C有一张票，这张票的ID是长度为6的字符串，每个字符都是数字，
	他想让这个ID变成他的辛运ID，所以他就开始更改ID，每一次操作，他可以选择任意一个数字并且替换它。
	如果这个ID的前三位数字之和等于后三位数字之和，那么这个ID就是辛运的。你帮小C求一下，最少需要操作几次，能使ID变成辛运ID
输入
输入只有一行，是一个长度为6的字符串。

输出
输出这个最小操作次数
样例输入
000000
样例输出
0
Hint
输入样例2
000018

输出样例2
1

样例解释：将前三位任意一个改为9即可满足条件，操作数为1

 */
/**
 * @description : 幸运ID
 * @author      : dingjie
 * @date 	    : 2018年9月15日 上午10:38:57 
 */
public class Iqiyi_2018091601 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();	
		
		scanner.close();
		int[] num = new int[6];
		int front = 0,back = 0,differ,step = 0;
		
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(str.substring(i, i+1));
			if(i > 2) back = back + num[i];
			else front = front + num[i];
		}
		
		differ = Math.abs(back - front);
		if(differ == 0) {
			System.out.println(step);
			return ;
		}
	
		sort1(num);
		
		if(front > back ) {
			if(num[3] + differ > 9) {
				differ = differ - (9 - num[3]);
				if(num[4] + differ > 9) {
					System.out.println(3);
				}else {
					System.out.println(2);
					return ;
				}
			}else {
				System.out.println(1);
				return ;
			}
		}else {
			if(num[0] + differ > 9) {
				differ = differ - (9 - num[0]);
				if(num[1] + differ > 9) {
					System.out.println(3);
				}else {
					System.out.println(2);
					return ;
				}
			}else {
				System.out.println(1);
				return ;
			}
		}	
	}
	
	public static void sort1(int[] arr) {
		int n = 3;		
        for(int i = 1; i < n; ++i){ 
            if(arr[i] < arr[i-1]){ 
            	int j = i-1;
                int x = arr[i];    
                while(j >= 0 && x < arr[j]){
                    arr[j+1] = arr[j];
                    j--;
                }
                arr[j+1] = x; 
            }
        }
        n = 6;
        for(int i = 3; i < n; ++i){ 
            if(arr[i] < arr[i-1]){ 
            	int j = i-1;
                int x = arr[i]; 
                while(j >= 3 && x < arr[j]){
                    arr[j+1] = arr[j];
                    j--;   
                }
                arr[j+1] = x; 
            }
        }
	}
}
