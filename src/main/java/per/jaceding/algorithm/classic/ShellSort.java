package per.jaceding.algorithm.classic;

/**
 * 希尔排序
 *
 * @author jaceding
 * @date 2017年9月4日 下午1:54:03
 */
public class ShellSort {

    /**
     * 希尔排序
     *
     * @param arr 待排数组
     */
    public static void sort(int[] arr) {
        int len = arr.length;
        int incre, temp, j;

        //控制incre的大小
        for (incre = len / 2; incre >= 1; incre = incre / 2) {
            //每组的直接插入排序
            for (int i = incre; i < len; ++i) {
                if (arr[i] < arr[i - incre]) {
                    temp = arr[i];
                    for (j = i - incre; j >= 0 && arr[j] > temp; j = j - incre) {
                        arr[j + incre] = arr[j];
                    }
                    arr[j + incre] = temp;
                }
            }
        }
    }

    /**
     * 希尔排序
     *
     * @param arr 待排数组
     */
    public static void sort2(int[] arr) {
        int len = arr.length;
        int incre = len / 2;
        int j;
        int temp;

        while (incre >= 1) {
            for (int i = incre; i < len; i++) {
                temp = arr[i];
                j = i - incre;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + incre] = arr[j];
                    j = j - incre;
                }
                arr[j + incre] = temp;
            }
            incre = incre / 2;
        }
    }
}
