package pers.dingjie.ccf.time_2016_12;

import java.util.Scanner;

/**
 * @Author: 丁杰
 * @Description:
 * @Date: Created in 22:48 2017/12/9
 */
public class answer_1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int []data=new int [1050];
        int n=input.nextInt();
        for(int i=0;i<n;i++){
            data[input.nextInt()]++;//桶排序法
        }
        boolean flag=false;
        for(int i=0;i<1050;i++){
            int countmin=0,countmax=0;
            for(int j=0;j<i;j++){//小于i的个数
                countmin+=data[j];
            }
            for(int t=i+1;t<1050;t++){//大于i的个数
                countmax+=data[t];
            }
            if(countmax==countmin&&data[i]!=0){
                System.out.println(i);
                flag=true;
            }
        }
        if(!flag)//不存在中间数
            System.out.println(-1);
    }
}
