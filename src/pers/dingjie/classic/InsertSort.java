package pers.dingjie.classic;

/**
 * @description : 插入排序
 * @author      : dingjie
 * @date 	    : 2017年7月24日 上午10:22:32 
 */
public class InsertSort {
    public static void main(String[] args) {
        new InsertSort().run();
    }

    private void run() {
        int a[] = {3,1,5,7,2,4,9,6};
        insertSort(a,8);
        for(Integer o:a){
            System.out.println(" "+o);
        }
    }
    void insertSort(int a[], int n)
    {
        for(int i= 1; i<n; i++){
            if(a[i] < a[i-1]){               //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入
                int j= i-1;
                int x = a[i];        //复制为哨兵，即存储待排序元素
                a[i] = a[i-1];           //先后移一个元素
                while(x < a[j]&&j>0){  //查找在有序表的插入位置
                    a[j+1] = a[j];
                    j--;         //元素后移
                }
                a[j+1] = x;      //插入到正确位置
            }
//            System.out.print(a,n,i);           //打印每趟排序的结果
        }

    }
}
