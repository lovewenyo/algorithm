package pers.dingjie.ccf.time_2013_12;

import java.util.Scanner;
/**
问题描述
　　给定n个正整数，找出它们中出现次数最多的数。如果这样的数有多个，请输出其中最小的一个。
输入格式
　　输入的第一行只有一个正整数n(1 ≤ n ≤ 1000)，表示数字的个数。
　　输入的第二行有n个整数s1, s2, …, sn (1 ≤ si ≤ 10000, 1 ≤ i ≤ n)。相邻的数用空格分隔。
输出格式
　　输出这n个次数中出现次数最多的数。如果这样的数有多个，输出其中最小的一个。
样例输入
6
10 1 10 20 30 20
样例输出
10
 */
/**
 * @description : 出现次数最多的数
 * @author      : dingjie
 * @date 	    : 2018年7月24日 上午10:08:04 
 */
public class Demo1 {

	public static void main(String[] args) {
		
		new Demo1().run();
	}
	
	public static void run() {
		int n,max;
		int nums[] = new int[10001];
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		
		for(int i = 0 ;i < n;i ++) {
			nums[scanner.nextInt()]++;
		}
		
		max = 1;
		int count = 0;
		for(int i = 1;i<10000;i++) {
			if(nums[i]==0) {
				continue;
			}else {
				count+=nums[i];
				if(nums[i]>nums[max]) {
					max = i;
				}
			}
			if(count == n) {
				break;
			}
		}
		System.out.println(max);
	}
	
}
