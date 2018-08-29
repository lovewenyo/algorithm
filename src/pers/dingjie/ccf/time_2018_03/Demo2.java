package pers.dingjie.ccf.time_2018_03;

import java.util.Scanner;

/**
问题描述
　　数轴上有一条长度为L（L为偶数)的线段，左端点在原点，右端点在坐标L处。有n个不计体积的小球在线段上，开始时所有的小球都处在偶数坐标上，速度方向向右，速度大小为1单位长度每秒。
　　当小球到达线段的端点（左端点或右端点）的时候，会立即向相反的方向移动，速度大小仍然为原来大小。
　　当两个小球撞到一起的时候，两个小球会分别向与自己原来移动的方向相反的方向，以原来的速度大小继续移动。
　　现在，告诉你线段的长度L，小球数量n，以及n个小球的初始位置，请你计算t秒之后，各个小球的位置。
提示
　　因为所有小球的初始位置都为偶数，而且线段的长度为偶数，可以证明，不会有三个小球同时相撞，小球到达线段端点以及小球之间的碰撞时刻均为整数。
　　同时也可以证明两个小球发生碰撞的位置一定是整数（但不一定是偶数）。
输入格式
　　输入的第一行包含三个整数n, L, t，用空格分隔，分别表示小球的个数、线段长度和你需要计算t秒之后小球的位置。
　　第二行包含n个整数a1, a2, …, an，用空格分隔，表示初始时刻n个小球的位置。
输出格式
　　输出一行包含n个整数，用空格分隔，第i个整数代表初始时刻位于ai的小球，在t秒之后的位置。
样例输入
3 10 5
4 6 8
样例输出
7 9 9
 */

/**
 * @description : 碰撞的小球
 * @author      : dingjie
 * @date 	    : 2018年8月28日 下午4:42:09 
 */
public class Demo2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n,l,t;  
		n = scanner.nextInt();
		l = scanner.nextInt();
		t = scanner.nextInt();
		Ball[] balls= new Ball[n];
		for (int i = 0; i < n; i++) {
			balls[i] = new Ball(scanner.nextInt());
		}
		scanner.close();

		run(balls,t,l);
		
		for (int i = 0; i < n; i++) {
			System.out.printf(balls[i].position + "  ");
		}
	}

	public static void run(Ball[] balls,int t,int l) {	
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < balls.length; j++) {
				if(balls[j].getPosition() == l && 
						balls[j].getDirection() == 1) {
					//与右端点相撞
					balls[j].setDirection(-1);
				}
				if(balls[j].getPosition() == 0 &&
						balls[j].getDirection() == -1) {
					//与左端点相撞
					balls[j].setDirection(1);
				}
				for (int k = 0; k < balls.length; k++) {
					if(j != k && balls[j].getPosition() == balls[k].getPosition() &&
							balls[j].getDirection() != balls[k].getDirection()) {
						//与其他球相撞
						balls[j].setDirection(-balls[j].getDirection());
						balls[k].setDirection(-balls[k].getDirection());
					}
				}
				//计算1s后的位置
				balls[j].setPosition(balls[j].getPosition() + balls[j].getDirection() * balls[j].getSpeed());
			}		
		}
	}
}
class Ball{
	
	int position;    //当前所在的位置
	
	int direction;	 //方向 1为向右 -1 向左
	
	int speed;       //速度默认为1
	
	public Ball() {
		
	}
	
	public Ball(int position) {
		this.position = position;
		this.direction = 1;
		this.speed = 1;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}

