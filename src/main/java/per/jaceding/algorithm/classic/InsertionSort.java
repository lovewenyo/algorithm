package per.jaceding.algorithm.classic;

/**
 * 插入排序
 *
 * @author jaceding
 * @date 2017年7月24日 上午10:22:32
 */
public class InsertionSort {

    /**
     * 传统直接插入排序
     *
     * @param arr 待排数组
     */
    public static void sort(int[] arr) {
        int len = arr.length;
        //控制需要比较的数据的下标
        for (int i = 1; i < len; ++i) {
            //若第i个元素大于i-1元素，直接插入。小于的话，移动有序表后插入
            if (arr[i] < arr[i - 1]) {
                int j = i - 1;
                //复制为哨兵，即存储待排序元素
                int x = arr[i];
                //查找在有序表的插入位置
                while (j >= 0 && x < arr[j]) {
                    arr[j + 1] = arr[j];
                    //元素后移
                    j--;
                }
                //插入到正确位置
                arr[j + 1] = x;
            }
        }
    }

    /**
     * 直接插入排序的另一个版本
     *
     * @param arr 待排数组
     */
    public static void sort2(int[] arr) {
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            int x = arr[i];
            int j = i - 1;

            for (; j >= 0 && arr[j] > x; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = x;
        }
    }

    /**
     * 其他版本的插入排序
     * 效率低
     *
     * @param arr 待排数组
     */
    public static void sort3(int[] arr) {
        int len = arr.length;
        int temp;
        //控制需要比较的数据的下标
        for (int i = 1; i < len; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                //如果说，发现后面的比前面的小说明需要进行交换了
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else {
                    //否则说明 i之前的序列已经是有序的了
                    break;
                }
            }
        }
    }

    /**
     * 折半插入排序
     * 如果比较操作的代价比交换操作大的话，可以采用二分查找法来减少比较操作的数目
     *
     * @param arr 待排数组
     */
    public static void sort4(int[] arr) {
        int len = arr.length;

        for (int i = 1; i < len; i++) {
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
