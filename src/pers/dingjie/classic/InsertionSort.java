package pers.dingjie.classic;

/**
 * @author : dingjie
 * @description : 插入排序
 * @date : 2017年7月24日 上午10:22:32
 */
public class InsertionSort {

    /**
     * @description 传统直接插入排序
     */
    public void insertionSort_1(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; ++i) {         //控制需要比较的数据的下标
            if (arr[i] < arr[i - 1]) {           //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入
                int j = i - 1;
                int x = arr[i];             //复制为哨兵，即存储待排序元素
                while (j >= 0 && x < arr[j]) { //查找在有序表的插入位置
                    arr[j + 1] = arr[j];
                    j--;                     //元素后移
                }
                arr[j + 1] = x;                 //插入到正确位置
            }
        }
    }

    /**
     * @description 直接插入排序的另一个版本
     */
    public void insertionSort_2(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int x = arr[i];
            int j = i - 1;

            for (; j >= 0 && arr[j] > x; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = x;
        }
    }

    /**
     * @description 其他版本的插入排序
     * 效率低
     */
    public void insertionSort_3(int arr[]) {
        int n = arr.length;
        int temp;

        for (int i = 1; i < n; ++i) {            //控制需要比较的数据的下标
            for (int j = i - 1; j >= 0; --j) {
                if (arr[j] > arr[j + 1]) {        //如果说，发现后面的比前面的小说明需要进行交换了
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else break;                    //否则说明 i之前的序列已经是有序的了
            }
        }
    }

    /**
     * @description 折半插入排序
     * 改进:如果比较操作的代价比交换操作大的话，可以采用二分查找法来减少比较操作的数目。
     */
    public void binaryInsertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int low = 0;
            int high = i - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            for (int j = i; j >= low + 1; j--) {
                arr[j] = arr[j - 1];
            }
            arr[low] = temp;
        }
    }

}
