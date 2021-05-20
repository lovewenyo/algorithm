package per.jaceding.algorithm.classic;

import java.util.Scanner;

/**
 * 迪杰斯特拉
 *
 * @author jaceding
 * @date 2018年9月5日 下午3:52:06
 */
public class Dijkstra {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //顶点的个数
        int m = scanner.nextInt();
        //边的条数
        int n = scanner.nextInt();
        int[][] arcs = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                arcs[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            arcs[scanner.nextInt()][scanner.nextInt()] = scanner.nextInt();
        }
        scanner.close();

        int start = 1;
        int[] shortPath = dijkstra_1(arcs, start);

        for (int i = 0; i < shortPath.length; i++) {
            if (start != i) {
                System.out.println(start + " -> " + i + " :" + shortPath[i]);
            }
        }
    }

    /**
     * @description dijkstra实现
     */
    public static int[] dijkstra_1(int[][] arcs, int start) {
        int length = arcs.length;
        //存储 start到各点的最短距离
        int[] shortPath = new int[length];
        //出发点到出发点间距离为0
        shortPath[start] = 0;
        //记录各点是否访问过
        int[] visited = new int[length];
        //出发点到出发点的距离已求出
        visited[start] = 1;

        for (int i = 0; i < length; i++) {
            int k = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < length; j++) {
                if (visited[j] == 0 && arcs[start][j] < min) {
                    min = arcs[start][j];
                    k = j;
                }
            }
            if (k == -1) {
                break;
            }
            //选出一个距离start最近的未标记的顶点将新选出的顶点标记为以求出最短路径，且到start的最短路径为dmin。
            shortPath[k] = min;
            visited[k] = 1;

            //以k为中间点，修正从start到未访问各点的距离
            for (int j = 0; j < length; j++) {
                if (visited[j] == 0 && arcs[start][k] + arcs[k][j] < arcs[start][j]) {
                    arcs[start][j] = arcs[start][k] + arcs[k][j];
                }
            }
        }
        return shortPath;
    }
}
