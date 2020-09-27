package pers.dingjie.ccf.time_2013_12;

import java.util.Scanner;

/**
 * @author : dingjie
 * @description : 最大的矩形
 * @date : 2018年7月24日 上午10:09:00
 */
public class Demo3 {

    public static void main(String[] args) {
        new Demo3().run();
    }

    public void run() {
        int n, max;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        max = scanner.nextInt();
        scanner.close();
        int nums[] = new int[n];

        for (int i = 1; i < n; i++) {
            nums[i] = scanner.nextInt();
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        for (int i = 0; i < n; i++) {

        }

    }

}
