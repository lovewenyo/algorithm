package pers.dingjie.ccf.time_2017_03;

/**
 * @Author: 丁杰
 * @Description:
 * @Date: Created in 19:21 2017/12/9
 */

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 　体育老师小明要将自己班上的学生按顺序排队。他首先让学生按学号从小到大的顺序排成一排，学号小的排在前面，然后进行多次调整。
 * 一次调整小明可能让一位同学出队，向前或者向后移动一段距离后再插入队列。
 * 　　例如，下面给出了一组移动的例子，例子中学生的人数为8人。
 * 　　0）初始队列中学生的学号依次为1, 2, 3, 4, 5, 6, 7, 8；
 * 　　1）第一次调整，命令为“3号同学向后移动2”，表示3号同学出队，向后移动2名同学的距离，
 * 再插入到队列中，新队列中学生的学号依次为1, 2, 4, 5, 3, 6, 7, 8；
 * 　　2）第二次调整，命令为“8号同学向前移动3”，表示8号同学出队，向前移动3名同学的距离，
 * 再插入到队列中，新队列中学生的学号依次为1, 2, 4, 5, 8, 3, 6, 7；
 * 　　3）第三次调整，命令为“3号同学向前移动2”，表示3号同学出队，向前移动2名同学的距离，
 * 再插入到队列中，新队列中学生的学号依次为1, 2, 4, 3, 5, 8, 6, 7。
 * 　　小明记录了所有调整的过程，请问，最终从前向后所有学生的学号依次是多少？
 * 　　请特别注意，上述移动过程中所涉及的号码指的是学号，而不是在队伍中的位置。在向后移动时，
 * 移动的距离不超过对应同学后面的人数，如果向后移动的距离正好等于对应同学后面的人数则该同学会移动到队列的最后面。
 * 在向前移动时，移动的距离不超过对应同学前面的人数，如果向前移动的距离正好等于对应同学前面的人数则该同学会移动到队列的最前面。
 * <p>
 * 　输入的第一行包含一个整数n，表示学生的数量，学生的学号由1到n编号。
 * 　　第二行包含一个整数m，表示调整的次数。
 * 　　接下来m行，每行两个整数p, q，如果q为正，表示学号为p的同学向后移动q，如果q为负，表示学号为p的同学向前移动-q。
 */
public class test_2 {
    public static void main(String[] args) {
        new test_2().run();
    }

    private void run() {
        int n, m, p, i, q;
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input the number of students:");
        n = scanner.nextInt();
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (i = 0; i < n; i++) {
            num.add(i + 1);
        }
        System.out.println("please input the times of movement:");
        m = scanner.nextInt();
        for (i = 0; i < m; i++) {
            System.out.println("please input a student number and his movement distantce :");
            p = scanner.nextInt();
            q = scanner.nextInt();
            move(num, p, q);
        }
        for (Integer o : num) {
            System.out.print(" " + o);
        }
    }

    public void move(ArrayList<Integer> num, int p, int q) {
        int index = -1, t_index = -1, temp = -1;
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i) == p) {
                index = i;
            }
        }
        t_index = index + q;
        temp = num.get(index);
        if (q > 0) {
            for (int i = 0; i < q; i++) {
                num.set(index + i, num.get(index + i + 1));
            }
        } else {
            for (int i = 0; i > q; i--) {
                num.set(index + i, num.get(index + i - 1));
            }
        }
        num.set(t_index, p);
    }
}
