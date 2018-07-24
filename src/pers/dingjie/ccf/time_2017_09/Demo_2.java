package pers.dingjie.ccf.time_2017_09;
import java.util.ArrayList;
import java.util.Scanner;

/**
问题描述
　　有一个学校的老师共用N个教室，按照规定，所有的钥匙都必须放在公共钥匙盒里，老师不能带钥匙回家。每次老师上课前，都从公共钥匙盒里找到自己上课的教室的钥匙去开门，上完课后，再将钥匙放回到钥匙盒中。
　　钥匙盒一共有N个挂钩，从左到右排成一排，用来挂N个教室的钥匙。一串钥匙没有固定的悬挂位置，但钥匙上有标识，所以老师们不会弄混钥匙。
　　每次取钥匙的时候，老师们都会找到自己所需要的钥匙将其取走，而不会移动其他钥匙。每次还钥匙的时候，还钥匙的老师会找到最左边的空的挂钩，将钥匙挂在这个挂钩上。如果有多位老师还钥匙，则他们按钥匙编号从小到大的顺序还。如果同一时刻既有老师还钥匙又有老师取钥匙，则老师们会先将钥匙全还回去再取出。
　　今天开始的时候钥匙是按编号从小到大的顺序放在钥匙盒里的。有K位老师要上课，给出每位老师所需要的钥匙、开始上课的时间和上课的时长，假设下课时间就是还钥匙时间，请问最终钥匙盒里面钥匙的顺序是怎样的？
输入格式
　　输入的第一行包含两个整数N, K。
　　接下来K行，每行三个整数w, s, c，分别表示一位老师要使用的钥匙编号、开始上课的时间和上课的时长。可能有多位老师使用同一把钥匙，但是老师使用钥匙的时间不会重叠。
　　保证输入数据满足输入格式，你不用检查数据合法性。
输出格式
　　输出一行，包含N个整数，相邻整数间用一个空格分隔，依次表示每个挂钩上挂的钥匙编号。
样例输入
5 2
4 3 3
2 2 7
样例输出
1 4 3 2 5
样例说明
　　第一位老师从时刻3开始使用4号教室的钥匙，使用3单位时间，所以在时刻6还钥匙。第二位老师从时刻2开始使用钥匙，使用7单位时间，所以在时刻9还钥匙。
　　每个关键时刻后的钥匙状态如下（X表示空）：
　　时刻2后为1X345；
　　时刻3后为1X3X5；
　　时刻6后为143X5；
　　时刻9后为14325。
样例输入
5 7
1 1 14
3 3 12
1 15 12
2 7 20
3 18 12
4 21 19
5 30 9
样例输出
1 2 3 5 4
评测用例规模与约定
　　对于30%的评测用例，1 ≤ N, K ≤ 10, 1 ≤ w ≤ N, 1 ≤ s, c ≤ 30；
　　对于60%的评测用例，1 ≤ N, K ≤ 50，1 ≤ w ≤ N，1 ≤ s ≤ 300，1 ≤ c ≤ 50；
　　对于所有评测用例，1 ≤ N, K ≤ 1000，1 ≤ w ≤ N，1 ≤ s ≤ 10000，1 ≤ c ≤ 100。
 */
/**
 * @description : 公共钥匙盒
 * @author      : dingjie
 * @date 	    : 2018年7月24日 上午10:03:56 
 */
public class Demo_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //����ʦ
        ArrayList<Teacher> arrt1 = new ArrayList<Teacher>();
        //��Ҫ�黹��Կ��
        ArrayList<Integer> key = new ArrayList<Integer>();
        int time = 1;
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int i = 1; i <= K; i++) {
            Teacher t = new Teacher(sc.nextInt(), sc.nextInt(), sc.nextInt());
            arrt1.add(t);
        }
        while(time <= maxTime(arrt1)){
            returnKey(time, arrt1, arr, key);
            borrowKey(time, arrt1, arr);
            time++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void returnKey(int time, ArrayList<Teacher> arrt1, int[] arr, ArrayList<Integer> key) {
        key.clear();
        for (int i = 0; i < arrt1.size(); i++) {
            if (arrt1.get(i).e == time) {
                key.add(arrt1.get(i).w);
            }
        }
        if (key.isEmpty()) {
            return;
        } else {
            for (int i = 0; i < key.size() - 1; i++) {
                for (int j = 0; j < key.size() - 1 - i; j++) {
                    if (key.get(j) > key.get(j + 1)) {
                        int temp = key.get(j);
                        key.set(j, key.get(j + 1));
                        key.set(j + 1, temp);
                    }
                }
            }
            for (int i = 0, j = 0; i < arr.length; i++) {
                if(arr[i] == 0){
                    arr[i] = key.get(j);
                    if(key.size()-1 == j){
                        break;
                    }else{
                        j++;
                    }
                }
            }
        }
    }

    public static void borrowKey(int time, ArrayList<Teacher> arrt1, int[] arr){
        for (int i = 0; i < arrt1.size(); i++) {
            if(time == arrt1.get(i).s){
                for (int j = 0; j < arr.length; j++) {
                    if(arrt1.get(i).w == arr[j]){
                        arr[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    public static int maxTime(ArrayList<Teacher> arrt1){
        int temp = 0;
        for (int i = 0; i < arrt1.size(); i++) {
            if(arrt1.get(i).e > temp){
                temp = arrt1.get(i).e;
            }
        }
        return temp;
    }
}

class Teacher {
    int w;
    int s;
    int c;
    int e;

    public Teacher(int w, int s, int c) {
        this.w = w;
        this.s = s;
        this.c = c;
        this.e = this.s + this.c;
    }
}