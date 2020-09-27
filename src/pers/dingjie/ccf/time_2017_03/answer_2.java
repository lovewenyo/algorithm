package pers.dingjie.ccf.time_2017_03;

import java.util.Scanner;

/**
 * @Author: 丁杰
 * @Description:
 * @Date: Created in 22:55 2017/12/9
 */
public class answer_2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int students = in.nextInt();
        int changes = in.nextInt();
        int[] list = new int[students];
        for (int i = 0; i < students; i++)
            list[i] = i + 1;

        for (int i = 0; i < changes; i++) {
            int nums = in.nextInt();
            int range = in.nextInt();
            int index = find(list, nums);
            if (range > 0) {
                while (range != 0) {
                    swap(list, index, index + 1);
                    index++;
                    range--;
                }
            } else if (range < 0) {
                while (range != 0) {
                    swap(list, index, index - 1);
                    index--;
                    range++;
                }
            }
        }

        for (int i = 0; i < students - 1; i++)
            System.out.print(list[i] + " ");
        System.out.println(list[students - 1]);
    }

    public static int find(int[] array, int num) {
        for (int index = 0; index <= array.length; index++) {
            if (array[index] == num)
                return index;
        }
        return -1;
    }

    public static void swap(int[] array, int x, int y) {
        int xx = array[x];
        int yy = array[y];
        array[x] = yy;
        array[y] = xx;
    }
}
