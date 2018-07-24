package pers.dingjie.ccf.time_2014_03;

import java.util.Scanner;

/**
问题描述
　　有 N 个非零且各不相同的整数。请你编一个程序求出它们中有多少对相反数(a 和 -a 为一对相反数)。
输入格式
　　第一行包含一个正整数 N。(1 ≤ N ≤ 500)。
　　第二行为 N 个用单个空格隔开的非零整数,每个数的绝对值不超过1000,保证这些整数各不相同。
输出格式
　　只输出一个整数,即这 N 个数中包含多少对相反数。
样例输入
5
1 2 3 -1 -2
样例输出
2
 */
/**
 * @description : 相反数
 * @author      : dingjie
 * @date 	    : 2018年7月24日 上午10:06:54 
 */
public class Demo1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int temp ;
		int n = sc.nextInt();
		int zhengshu[] = new int[1001];
		int fushu[] = new int[1001];
		
		for(int i = 0; i<n ;i++) {
			temp = sc.nextInt();
			if(temp>0) {
				zhengshu[temp]++;
			}
			if(temp<0){
				fushu[-1*temp]++;
			}
		}
		
		int count=0;
		for(int i = 1; i<=1000;i++) {
			if(zhengshu[i]!=0) {
				if(fushu[i]!=0) {
					count++;
				}
			}
		}
		
		System.out.println(count);
	}

}
