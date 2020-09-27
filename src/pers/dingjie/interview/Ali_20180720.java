package pers.dingjie.interview;

import java.util.Scanner;
/**
 * 问题描述
 * 某物流派送员p，需要给a、b、c、d4个快递点派送包裹，请问派送员需要选择什么的路线，才能完成最短路程的派送。
 * 假设如图派送员的起点坐标(0,0)，派送路线只能沿着图中的方格边行驶，每个小格都是正方形，且边长为1，如p到d的距离就是4。
 * 随机输入n个派送点坐标，求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
 * 输入:
 * 4
 * 2,2
 * 2,8
 * 4,4
 * 7,2
 * 输出:
 * 30
 * 输入范例:
 * 3
 * 2,2
 * 2,8
 * 6,6
 * 输出范例:
 * 28
 */

/**
 * @description : 最短路径(包含回来)
 * @author      : dingjie
 * @date        : 2018年7月20日 下午2:49:52
 */
public class Ali_20180720 {

    final Point START = new Point(0, 0);
    /** 定义起点 */
    int minpath = Integer.MAX_VALUE;
    int count_ = 0;

    public static void main(String[] args) {
        new Ali_20180720().run();
    }

    public int calculate(Point start, Point[] points, int sum, int count) {
        if (count == points.length) {
            minpath = Math.min(minpath, sum + start.getLength(START));
            return minpath;
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i].visited == false) {
                sum += points[i].getLength(start);
                if (sum < minpath) {
                    points[i].visited = true;
                    calculate(points[i], points, sum, count + 1);
                }
                sum -= points[i].getLength(start);
                points[i].visited = false;
            }
        }
        return minpath;
    }

    private void run() {

        Scanner input = new Scanner(System.in);
        int pnum = Integer.parseInt(input.nextLine().trim());    /** 点的个数 */

        Point[] points = new Point[pnum];                        /** 构建点集 */
        for (int i = 0; i < pnum; i++) {
            String[] locations = input.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }

        input.close();
        long startTime = System.currentTimeMillis();
        int min = calculate(START, points, 0, 0);
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(min);
    }

    class Point {

        int x;
        /** x轴坐标  */

        int y;
        /** y轴坐标  */

        boolean visited;

        /** 访问标记 */

        public Point() {

        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.visited = false;
        }

        /** 计算两点之间的距离
         * @param p 点
         * @return 两点之间的距离
         */
        public int getLength(Point p) {
            return Math.abs(x - p.x) + Math.abs(y - p.y);
        }
    }
}
