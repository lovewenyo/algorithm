package pers.dingjie.ccf.time_2017_12;

import java.util.Scanner;
/**
 * 问题描述
 * 　　有n个小朋友围成一圈玩游戏，小朋友从1至n编号，2号小朋友坐在1号小朋友的顺时针方向，
 * 3号小朋友坐在2号小朋友的顺时针方向，……，1号小朋友坐在n号小朋友的顺时针方向。
 * 　　游戏开始，从1号小朋友开始顺时针报数，接下来每个小朋友的报数是上一个小朋友报的数加1。
 * 若一个小朋友报的数为k的倍数或其末位数（即数的个位）为k，则该小朋友被淘汰出局，不再参加以后的报数。
 * 当游戏中只剩下一个小朋友时，该小朋友获胜。
 * 　　例如，当n=5, k=2时：
 * 　　1号小朋友报数1；
 * 　　2号小朋友报数2淘汰；
 * 　　3号小朋友报数3；
 * 　　4号小朋友报数4淘汰；
 * 　　5号小朋友报数5；
 * 　　1号小朋友报数6淘汰；
 * 　　3号小朋友报数7；
 * 　　5号小朋友报数8淘汰；
 * 　　3号小朋友获胜。
 * <p>
 * 　　给定n和k，请问最后获胜的小朋友编号为多少？
 * 输入格式
 * 　　输入一行，包括两个整数n和k，意义如题目所述。
 * 输出格式
 * 　　输出一行，包含一个整数，表示获胜的小朋友编号。
 * 样例输入
 * 5 2
 * 样例输出
 * 3
 * 样例输入
 * 7 3
 * 样例输出
 * 4
 * 数据规模和约定
 * 　　对于所有评测用例，1 ≤ n ≤ 1000，1 ≤ k ≤ 9。
 */

/**
 * @description : 游戏
 * @author      : dingjie
 * @date        : 2018年7月24日 上午9:58:56 
 */
public class Demo2 {
    public static void main(String[] args) {

        int n, k, lifenum, saynum = 0;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        lifenum = n;
        k = scanner.nextInt();
        int life[] = new int[n];
        scanner.close();

        while (lifenum > 1) { //当前为未出局的小朋友等于1游戏结束

            for (int i = 0; i < life.length; i++) {
                if (life[i] != -1) {
                    //如果未出局则报数
                    saynum++;
                    life[i] = saynum;
                    if (life[i] != -1 && (life[i] % k == 0 || life[i] % 10 == k)) {
                        //如果未出局且报的数为k的倍数或其末位数（即数的个位）为k，则淘汰出局
                        life[i] = -1;
                        lifenum--;
                    }
                }
            }
        }

        //输出获胜的小朋友编号
        for (int i = 0; i < life.length; i++) {
            if (life[i] != -1) {
                System.out.println(i + 1);
            }
        }


    }
}
