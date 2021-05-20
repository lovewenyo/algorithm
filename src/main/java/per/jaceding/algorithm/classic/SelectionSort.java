package per.jaceding.algorithm.classic;

/**
 * 选择排序
 *
 * @author jaceding
 * @date 2017年9月11日 下午2:27:14
 */
public class SelectionSort {

    /**
     * 传统简单选择排序
     *
     * @param arr 待排数组
     */
    public static void sort(int[] arr) {
        int len = arr.length;
        int minIndex ,temp;

        for (int i = 0; i < len - 1; ++i) {
            minIndex = i;

            for (int j = i + 1; j < len; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * 改进后的简单选择排序
     * 每次找到最小的数和最大的数
     *
     * @param arr 待排数组
     */
    public static void sort2(int[] arr) {
        int n = arr.length;
        int minIndex, maxIndex, temp;

        for (int i = 0; i < n / 2; ++i) {
            minIndex = i;
            maxIndex = n - i - 1;
            for (int j = i + 1; j < n - i; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            if (maxIndex != n - i - 1) {
                temp = arr[n - i - 1];
                arr[n - i - 1] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }
}
