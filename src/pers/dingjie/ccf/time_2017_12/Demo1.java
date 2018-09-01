package pers.dingjie.ccf.time_2017_12;

import java.util.Scanner;

/**
问题描述
　　给定n个数，请找出其中相差（差的绝对值）最小的两个数，输出它们的差值的绝对值。
输入格式
　　输入第一行包含一个整数n。
　　第二行包含n个正整数，相邻整数之间使用一个空格分隔。
输出格式
　　输出一个整数，表示答案。
样例输入
5
1 5 4 8 20
样例输出
1
样例说明
　　相差最小的两个数是5和4，它们之间的差值是1。
样例输入
5
9 3 6 1 3
样例输出
0
样例说明
　　有两个相同的数3，它们之间的差值是0.
数据规模和约定
　　对于所有评测用例，2 ≤ n ≤ 1000，每个给定的整数都是不超过10000的正整数。
*/

/**
 * @description : 最小差值
 * @author      : dingjie
 * @date 	    : 2018年7月24日 上午9:57:20 
 */
public class Demo1 {
	
	public static void main(String[] args) {
		Scanner src=new Scanner(System.in);  
        int n=src.nextInt();          
        int array[]=new int[n];   
        int temp,min=10000; 
          
        for (int i = 0; i < n; i++) {               
            array[i]=src.nextInt();  
        }  
        src.close();    
          
        //比较所有数的差值找出最小差值
        for (int i = 0; i < n; i++) {      
            for (int j = i+1; j < n; j++) {                  
                temp=array[i]-array[j];      
                if(temp<0)    temp=-temp;                 
                if(temp<min)  min=temp;  
            }  
        }  
        System.out.println(min);  
		
	}

}
