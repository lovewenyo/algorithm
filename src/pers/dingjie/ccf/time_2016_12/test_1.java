package pers.dingjie.ccf.time_2016_12;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: 丁杰
 * @Description:
 * @Date: Created in 20:22 2017/12/9
 */

/**
 * 在一个整数序列a1, a2, …, an中，如果存在某个数，大于它的整数数量等于小于它的整数数量，则称其为中间数。
 * 在一个序列中，可能存在多个下标不相同的中间数，这些中间数的值是相同的。
 * 　　给定一个整数序列，请找出这个整数序列的中间数的值。
 * <p>
 * 输入的第一行包含了一个整数n，表示整数序列中数的个数。
 * 　　第二行包含n个正整数，依次表示a1, a2, …, an。
 * <p>
 * 如果约定序列的中间数存在，则输出中间数的值，否则输出-1表示不存在中间数。
 */
public class test_1 {
    public static void main(String[] args) {
        new test_1().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> num = new ArrayList<Integer>();
        System.out.println("input the n:");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            num.add(scanner.nextInt());
        }
        int mid = -1;
        for (Integer o : num) {
            mid = getMid(num, o);
            if (mid != -1) {
                System.out.println("mid :" + mid);
            }
        }
        if (mid == -1) {
            System.out.println("mid :" + mid);
        }
    }

    public int getMid(ArrayList<Integer> num, int a) {
        int left = 0, right = 0;
        for (Integer o : num) {
            if (o < a) left++;
            if (o > a) right++;
        }
        if (left == right && left != 0) {
            return a;
        }
        return -1;
    }
}
