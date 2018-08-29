package pers.dingjie.ccf.time_2018_03;

import java.util.LinkedList;
import java.util.Scanner;

/**
样例输入
3
1 2 1
2 1 2
0 0 0
2 1 1
0 2 1
0 0 2
0 0 0
0 0 0
0 0 0
样例输出
3
-4
0
 */

/**
 * @description : 棋局评估
 * @author      : dingjie
 * @date 	    : 2018年8月29日 下午4:20:46 
 */
public class Demo4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		LinkedList<Integer> list = new LinkedList<Integer>();
		int[] board = new int[9];
		
		for (int i = 0; i < t; i++) {
			for (int j = 0; j < 9; j++) {
				list.add(scanner.nextInt());				
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			int j = (i+1) % 9;		
			if(j == 0) {
				board[8] = list.get(i);
				calculate(board);			
			}else {
				board[j-1] = list.get(i);
			}
		}
	}
	
	public static void calculate(int[] board) {
		if(hasWin(board,1)) {
			int score = 1+blank(board);
			System.out.println(score);
			return ;
		}
		if(hasWin(board,2)) {
			int score = -(1+blank(board));
			System.out.println(score);
			return ;
		}
		if(blank(board) == 9) {
			//如果一步都没走，平局
			System.out.println(0);
			return ;
		}
		if(blank(board) == 7) {
			//如果走了两步，则需要判断
			if(atSafe(board,1) && !atSafe(board,2)) {
				//Alice在安全区 Bob在危险区 Alice赢 最终空格为2
				System.out.println(1+2);
				return ;
			}else {
				//平局
				System.out.println(0);
				return ;
			}
		}
		if(blank(board) == 5) {
			//走了四部 没人走两步
			if(hasDead(board,2)) {
				//可能Bob送死，只需要一步Alice赢(最后剩下4个空格)
				System.out.println(1+4);
				return ;
			}
			if(board[4] == 1 && !atDanger(board,1) && atDanger(board,2)) {
				//如果Alice都在安全区并有一个元素在中心，Bob存在元素在危险区，Alice必胜(最后剩下两个空格)
				System.out.println(1+2);
				return ;
			}
			if(board[4] == 2 && !atDanger(board,2) && !atSafe(board,1)) {
				//如果Bob都在安全区并有一个元素在中心，Alice元素都在危险区，Bob必胜(最后剩下一个空格)
				System.out.println(-(1+1));
				return ;
			}
			//平局
			System.out.println(0);
			return ;
		}
		if(blank(board) == 3) {
			//走了六部
			if(hasDead(board,2)) {
				//可能Bob必死，只需要一步Alice赢(最后剩下2个空格)
				System.out.println(1+2);
				return ;
			}
			if(hasDead(board,1)) {
				//可能Alice必死，但还需要走两步，剩余一个空格
				System.out.println(-(1+1));
				return ;
			}
			System.out.println(0);
			return ;
		}
		if(blank(board) == 1) {
			//走了八部 那就让Alice走完最后一步 看看是否赢了
			for (int i = 0; i < board.length; i++) {
				if(board[i] == 0) {
					board[i] = 1;
				}
			}
			if(hasWin(board,1)) {
				System.out.println(1+0);
				return ;
			}
			//平局
			System.out.println(0);
			return ;
		}
	}

	public static boolean hasWin(int[] board,int a) {
		if(board[0] == board[1]&&board[0] == board[2]&&board[0] == a) {
			return true;
		}
		if(board[3] == board[4]&&board[3] == board[5]&&board[3] == a) {
			return true;
		}
		if(board[6] == board[7]&&board[7] == board[8]&&board[8] == a) {
			return true;
		}
		if(board[0] == board[3]&&board[3] == board[6]&&board[0] == a) {
			return true;
		}
		if(board[1] == board[4]&&board[4] == board[7]&&board[1] == a) {
			return true;
		}
		if(board[2] == board[5]&&board[2] == board[8]&&board[2] == a) {
			return true;
		}
		if(board[0] == board[4]&&board[0] == board[8]&&board[0] == a) {
			return true;
		}
		if(board[2] == board[4]&&board[6] == board[2]&&board[2] == a) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description 判断某个人a 下一步是否必死
	 */
	public static boolean hasDead(int[] board,int a) {
		if(a == 2) {
			//bob必死
			for (int i = 0; i < board.length; i++) {
				if(board[i] == 0) {
					board[i] = 1;//先走一下
					if(hasWin(board,1)) {
						board[i] = 0;
						return true;
					}
					board[i] = 0;
				}
			}
			return false;
		}else {
			//Alice必死 要是无论Alice走哪，Bob赢
			boolean dead = true;
			for (int i = 0; i < board.length; i++) {
				if(board[i] == 0) {
					board[i] = 1;//Alice先走一下
					boolean win = false;
					for (int j = 0; j < board.length; j++) {
						if(board[j] == 0) { 
							board[j] = 2; //Bob走一下
							if(hasWin(board,2)) {
								board[j] = 0;
								board[i] = 0;
								win = true;
								break;
							}
							board[j] = 0;
							board[i] = 0;
						}
					}
					if(win == false) {
						dead = false;
					}
				}
			}	
			return dead;
		}

	}


	public static int blank(int[] board) {
		int i = 0;
		for (int j = 0; j < board.length; j++) {
			if(board[j] == 0){
				i++;
			}
		}
		return i;
	}

	/**
	 * @description 是否有元素在安全区
	 */
	public static boolean atSafe(int[] board,int i) {
		if(board[0] == i) {
			return true;
		}
		if(board[2] == i) {
			return true;
		}
		if(board[4] == i) {
			return true;
		}
		if(board[6] == i) {
			return true;
		}
		if(board[8] == i) {
			return true;
		}
		return false;
	}
	
	/**
	 * @description 是否有元素在危险区
	 */
	public static boolean atDanger(int[] board,int i) {
		if(board[1] == i) {
			return true;
		}
		if(board[3] == i) {
			return true;
		}
		if(board[5] == i) {
			return true;
		}
		if(board[7] == i) {
			return true;
		}
		return false;
	}
}
