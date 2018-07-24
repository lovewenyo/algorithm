package pers.dingjie.ccf.time_2017_03;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 小明今天生日，他有n块蛋糕要分给朋友们吃，这n块蛋糕（编号为1到n）的重量分别为a1, a2, …, an。
 * 小明想分给每个朋友至少重量为k的蛋糕。小明的朋友们已经排好队准备领蛋糕，对于每个朋友，
 * 小明总是先将自己手中编号最小的蛋糕分给他，当这个朋友所分得蛋糕的重量不到k时，
 * 再继续将剩下的蛋糕中编号最小的给他，直到小明的蛋糕分完或者这个朋友分到的蛋糕的总重量大于等于k。
 * 请问当小明的蛋糕分完时，总共有多少个朋友分到了蛋糕。
 *
 * 输入的第一行包含了两个整数n, k，意义如上所述。
 * 第二行包含n个正整数，依次表示a1, a2, …, an。
 *
 */
public class test_1 {
    public static void main(String[] args) {
        new test_1().run();
    }
    public void run(){
        int n , k, weigth = 0;

        ArrayList<Integer> a = new ArrayList<Integer>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("please input value of n and k :");
        n = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(" please input weights of every cake");
        for (int i = 0; i < n ; i++) {
            int num = scanner.nextInt();
            a.add(num);
        }
        for(Integer o :a){
            weigth += o;
        }
        int p = weigth / k;
        System.out.println(p );
    }
}
