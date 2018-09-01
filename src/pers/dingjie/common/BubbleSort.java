package pers.dingjie.sort;

/**
 * @description : 冒泡排序
 * @author      : dingjie
 * @date 	    : 201年7月24日 上午10:21:37
 */
public class BubbleSort {
    public static void main(String[] args) {
        new BubbleSort().run();
    }

    private void run() {
        int[] x = { 99, 65, 24, 47, 50, 88,33, 66, 67, 31, 18 };
        int n = 11;

        bubbleSort(x,n);
        System.out.print("bubbleSort:  ");
        for(Integer o :x){
            System.out.print(" "+o);
        }

        int [] x1 = { 99, 65, 24, 47, 50, 88,33, 66, 67, 31, 18 };
        bubbleSort_1(x1,n);
        System.out.print("\nbubbleSort_1:");
        for(Integer o :x1){
            System.out.print(" "+o);
        }

        int [] x2 = { 99, 65, 24, 47, 50, 88,33, 66, 67, 31, 18 };
        bubbleSort_2(x2,n);
        System.out.print("\nbubbleSort_2:");
        for(Integer o :x2){
            System.out.print(" "+o);
        }
    }

    public void bubbleSort(int []x, int n) {
         /**
           * @Description: 传统的冒泡排序
           * @param x`  //待排数组
         * @param n   //数组大小
           * @return void
           */
        for(int i =0 ; i< n-1; ++i) {
            for(int j = 0; j < n-i-1; ++j) {
                if(x[j] > x[j+1]){
                    int temp = x[j] ;
                    x[j] = x[j+1] ;
                    x[j+1] = temp;
                }
            }
        }
    }
    public void bubbleSort_1(int []x, int n){
        /**
         * @Description:  改进后的冒泡排序
         *       设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。
         *       由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可。
         *
         * @param x    //待排数组
        * @param n   //数组大小
         * @return void
         */

        int i= n -1;  //初始时,最后位置保持不变
        while ( i> 0) {
            int pos= 0;     //每趟开始时,无记录交换
            for (int j= 0; j< i; j++)
                if (x[j]> x[j+1]) {
                    pos= j; //记录交换的位置
                    int tmp = x[j];
                    x[j]=x[j+1];
                    x[j+1]=tmp;
                }
            i= pos;         //为下一趟排序作准备
        }

    }

    public void bubbleSort_2(int []x, int n){
         /**
           * @Description:  改进后的冒泡排序
          *      传统冒泡排序中每一趟排序操作只能找到一个最大值或最小值,
          *      我们考虑利用在每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) ,
          *      从而使排序趟数几乎减少了一半。
           * @param x  //待排数组
         * @param n   //数组大小
           * @return void
           */
        int low = 0;
        int high= n -1; //设置变量的初始值
        int temp,j;
        while (low < high) {
            for (j= low; j< high; ++j)  //正向冒泡,找到最大者
                if (x[j]> x[j+1]) {
                    temp = x[j];
                    x[j]=x[j+1];
                    x[j+1]=temp;
                }
            --high;                     //修改high值, 前移一位

            for ( j=high; j>low; --j)  //反向冒泡,找到最小者
                if (x[j]<x[j-1]) {
                    temp = x[j];
                    x[j]=x[j-1];
                    x[j-1]=temp;
                }
            ++low;                      //修改low值,后移一位

        }
    }


}
