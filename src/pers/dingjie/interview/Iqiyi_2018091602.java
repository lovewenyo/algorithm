package pers.dingjie.interview;

import java.util.Scanner;

/**
时间限制：C/C++语言 1000MS；其他语言 3000MS
内存限制：C/C++语言 131072KB；其他语言 655360KB

题目描述：
	局长有N种食物，每种食物有Ai份。
	每天局长会吃一份食物，或者买一份食物（即每天只能进行吃或买其中的一种动作），这样过了M天
	现在局长想知道M天后第p种食物的份数排名（从大到小，相同算并列，例如3 3 2，则排名为1 1 3）

N,M,P<=100,Ai<=1000

输入
第一行N M P
第二行N个数Ai
接下来M行，每行A i或者B i分别表示买一份食物i，吃一份食物i

输出
一个答案

样例输入
3 4 2
5 3 1
B 1
A 2
A 2
A 3
样例输出
1
 */

/**
 * @description : 局长的食物
 * @author      : dingjie
 * @date 	    : 2018年9月15日 上午11:27:39
 */
public class Iqiyi_2018091602 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(),m = scanner.nextInt(),p = scanner.nextInt();
		int s = 1;
		int[] food = new int[n];
		for (int i = 0; i < food.length; i++) {
			food[i] = scanner.nextInt();
		}
		while(m-- > 0) {
			if(scanner.next().equals("A")) {
				food[scanner.nextInt()-1] ++;
			}else {
				food[scanner.nextInt()-1] --;
			}
		}		
        scanner.close();
		for (int i = 0; i < food.length; i++) {
			if(i != p-1) {
				if(food[i]>food[p-1]) {
					s++;
				}
			}
		}
		
		System.out.println(s);
	}

}
