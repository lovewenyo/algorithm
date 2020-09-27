package pers.dingjie.ccf.time_2017_12;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 问题描述
 * 　　小明和小芳出去乡村玩，小明负责开车，小芳来导航。
 * 　　小芳将可能的道路分为大道和小道。大道比较好走，每走1公里小明会增加1的疲劳度。小道不好走，如果连续走小道，小明的疲劳值会快速增加，连续走s公里小明会增加s2的疲劳度。
 * 　　例如：有5个路口，1号路口到2号路口为小道，2号路口到3号路口为小道，3号路口到4号路口为大道，4号路口到5号路口为小道，相邻路口之间的距离都是2公里。如果小明从1号路口到5号路口，则总疲劳值为(2+2)2+2+22=16+2+4=22。
 * 　　现在小芳拿到了地图，请帮助她规划一个开车的路线，使得按这个路线开车小明的疲劳度最小。
 * 输入格式
 * 　　输入的第一行包含两个整数n, m，分别表示路口的数量和道路的数量。路口由1至n编号，小明需要开车从1号路口到n号路口。
 * 　　接下来m行描述道路，每行包含四个整数t, a, b, c，表示一条类型为t，连接a与b两个路口，长度为c公里的双向道路。其中t为0表示大道，t为1表示小道。保证1号路口和n号路口是连通的。
 * 输出格式
 * 　　输出一个整数，表示最优路线下小明的疲劳度。
 * 样例输入
 * 6 7
 * 1 1 2 3
 * 1 2 3 2
 * 0 1 3 30
 * 0 3 4 20
 * 0 4 5 30
 * 1 3 5 6
 * 1 5 6 1
 * 样例输出
 * 76
 * 样例说明
 * 　　从1走小道到2，再走小道到3，疲劳度为52=25；然后从3走大道经过4到达5，疲劳度为20+30=50；最后从5走小道到6，疲劳度为1。总共为76。
 * 数据规模和约定
 * 　　对于30%的评测用例，1 ≤ n ≤ 8，1 ≤ m ≤ 10；
 * 　　对于另外20%的评测用例，不存在小道；
 * 　　对于另外20%的评测用例，所有的小道不相交；
 * 　　对于所有评测用例，1 ≤ n ≤ 500，1 ≤ m ≤ 105，1 ≤ a, b ≤ n，t是0或1，c ≤ 105。保证答案不超过106。
 */

/**
 * @description : 行车路线
 * @author      : dingjie
 * @date        : 2018年9月1日 下午4:08:02 
 */
public class Demo4 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        long[][] edges = new long[n + 1][n + 1];

        int[][] tag = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(edges[i], 10 * 10 * 10 * 10 * 10 * 10);
        }
        for (int j = 0; j <= n; j++)
            edges[j][j] = 0;//这里其实做不做都可以 写32767也行
        for (int i = 0; i < m; i++) {
            int a1 = scanner.nextInt();//System.out.println(a1);//指示为大路（0）还是小路（1）
            int a2 = scanner.nextInt();//System.out.println(a2);//from
            int a3 = scanner.nextInt();//System.out.println(a3);//to
            long a4 = scanner.nextInt();//System.out.println(a4);//weight
            tag[a2][a3] = a1;
            tag[a3][a2] = a1;
            edges[a2][a3] = a4;
            edges[a3][a2] = a4;
        }
        scanner.close();

        long[] dist = new long[n + 1];//到待定点的距离
        long[] lianxi = new long[n + 1];//已连续走了多少路
        int[] visited = new int[n + 1];//该点是否已被访问
        Arrays.fill(dist, 10 * 10 * 10 * 10 * 10 * 10);
        dist[1] = 0;
        Arrays.fill(visited, 0);
        Arrays.fill(lianxi, 0);
        //如果距离初始化的话就可以按照课本来
        //否则按照下面步骤
        for (int j = 0; j < n; j++) {
            int v = -1;
            for (int k = 1; k <= n; k++) {
                if (visited[k] == 0) {
                    if (v == -1 || (dist[k] < dist[v]))
                        v = k;
                }

            }
            if (v == -1)//有没有都可以 前面for循环已经限定了次数
                break;
            visited[v] = 1;//将点拿入

            for (int mm = 1; mm <= n; mm++) {//大道
                if (visited[mm] == 0) {//这句话其实用不用都行  因为不这样也就是多搜索几遍而已
                    if (tag[v][mm] == 0) {
                        if (dist[mm] > dist[v] + edges[v][mm]) {
                            dist[mm] = dist[v] + edges[v][mm];
                            lianxi[mm] = 0;
                        }
                    }//小道
                    else if (tag[v][mm] == 1) {
                        if (lianxi[v] == 0) {
                            long temp = dist[v] + edges[v][mm] * edges[v][mm];
                            if (temp < dist[mm]) {
                                dist[mm] = temp;
                                lianxi[mm] = edges[v][mm];
                            }
                        } else {
                            long temp = dist[v] - lianxi[v] * lianxi[v] + (lianxi[v] + edges[v][mm]) * (lianxi[v] + edges[v][mm]);
                            if (temp < dist[mm]) {
                                dist[mm] = temp;
                                lianxi[mm] = edges[v][mm] + lianxi[v];
                            }
                        }
                    }
                }
            }
        }
        System.out.println(dist[n]);
    }
}