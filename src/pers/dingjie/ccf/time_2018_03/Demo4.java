package pers.dingjie.ccf.time_2018_03;

import java.util.Scanner;

/**
 * 样例输入
 * 3
 * 1 2 1
 * 2 1 2
 * 0 0 0
 * 2 1 1
 * 0 2 1
 * 0 0 2
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * 样例输出
 * 3
 * -4
 * 0
 */

/**
 * @description : 棋局评估
 * @author      : dingjie
 * @date        : 2018年8月29日 下午4:20:46 
 */

public class Demo4 {
    private static int[][] board = new int[3][3];//棋盘
    private static int ALICE = 1;
    private static int BOB = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T;//数据的组数
        while (scanner.hasNext()) {
            T = scanner.nextInt();

            for (int i = 0; i < T; i++) {
                //初始化棋盘
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        board[j][k] = scanner.nextInt();
                    }
                }

                int score = win(ALICE);
                if (score != 0) {
                    System.out.println(score);
                    continue;
                }
                score = win(BOB);
                if (score != 0) {
                    System.out.println(score);
                    continue;
                }

                System.out.println(dfs(ALICE));
            }

        }//while循环
        scanner.close();
    }

    private static int dfs(int user) {
        if (spa() == 0) {
            return 0;
        }
        int Max = -10, Min = 10;
        for (int i = 0; i < 3; i++) {
            for (int j = 0, w; j < 3; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = user;
                    w = win(user);
                    if (w != 0) {
                        board[i][j] = 0;
                        return w > 0 ? Math.max(Max, w) : Math.min(Min, w);
                    }
                    if (user == ALICE) {
                        Max = Math.max(Max, dfs(BOB));
                    } else {
                        Min = Math.min(Min, dfs(ALICE));
                    }
                    board[i][j] = 0;
                }
            }
        }
        return (user != ALICE) ? Min : Max;
    }

    private static int win(int f) {
        int wi = 0, ans = 1;
        if (hok(0, f) || hok(1, f) || hok(2, f)) {
            wi = 1;
        }
        if (lok(0, f) || lok(1, f) || lok(2, f)) {
            wi = 1;
        }

        if (board[0][0] == f && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            wi = 1;
        }

        if (board[0][2] == f && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            wi = 1;
        }
        if (wi == 0) {
            return 0;
        }
        ans += spa();
        return (f == ALICE) ? ans : -ans;
    }

    private static boolean lok(int l, int f) {
        return board[0][l] == f && board[0][l] == board[1][l] && board[1][l] == board[2][l];
    }

    private static boolean hok(int h, int f) {
        return board[h][0] == f && board[h][0] == board[h][1] && board[h][1] == board[h][2];
    }

    private static int spa() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
}