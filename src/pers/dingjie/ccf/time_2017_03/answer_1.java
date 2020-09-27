package pers.dingjie.ccf.time_2017_03;

import java.util.Scanner;

/**
 * @Author: 丁杰
 * @Description:
 * @Date: Created in 22:52 2017/12/9
 */
public class answer_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int friends = in.nextInt();
        int weight = in.nextInt();
        int nums = 1;
        int now = 0;
        for (int i = 0; i < friends; i++) {
            now += in.nextInt();

            if (now >= weight && i < friends - 1) {
                nums++;
                now = 0;
            }
        }

        System.out.println(nums);
    }
}
